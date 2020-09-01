package editor;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.TextRenderer;
import javafx.util.Pair;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import renderer.Building;
import renderer.Road;
import renderer.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RendererPanel extends JPanel implements GLEventListener {
    private static GLU glu;
    private static final int RENDER_DISTANCE = Integer.parseInt(EditorProperties.getInstance().get("render_distance"));
    private static final int GRID_SIZE = Integer.parseInt(EditorProperties.getInstance().get("grid_size"));
    List<Building> buildings = new ArrayList<>();
    List<Road> roads = new ArrayList<>();

    private double xAngle = -22.5;
    private double yAngle = 22.5;

    private Vector3D position = new Vector3D(10, 10, 10);

    private double fovX, fovY, width, height;

    private boolean debug = false;

    private Building selectedBuilding = null;
    private Road selectedRoad = null;
    private boolean previewRoad = false;

    private boolean draggingModeMove = false;
    private Vector3D originalPlaneIntersectionPoint = null;
    private Vector3D originalBuildingTranslation = null;
    private double originalBuildingIntersectionHeight = 0;

    private boolean draggingModeRotate = false;
    private double originalBuildingRotation = 0;

    private boolean pathEditMode = false;
    private JButton editButton = null;

    private Vector3D livePlaneIntersectionPoint = null;
    private Vector3D liveStartPoint = null;
    private Vector3D liveDirection = null;


    private int[] viewport;
    private double[] mvmatrix;
    private double[] projmatrix;


    private long[] lastFrameRenderTimes = new long[60];
    private int lastFrameRenderTimesIndex = 0;


    GLCanvas canvas = null;

    private List<BuildingChangedListener> buildingChangedListeners = new ArrayList<>();
    private List<RoadChangedListener> roadChangedListeners = new ArrayList<>();

    public RendererPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        RendererPanelMenu menu = new RendererPanelMenu();
        add(menu);

        menu.getAddPathButton().addActionListener((event) -> togglePathEditMode());
        editButton = menu.getAddPathButton();

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        glu = new GLU();

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        canvas = glcanvas;

        glcanvas.addGLEventListener(this);
        glcanvas.setPreferredSize(new Dimension(800, 900));

        add(glcanvas);

        setupCanvasListeners(glcanvas);

    }

    public void addBuildingChangedListener(BuildingChangedListener listener) {
        buildingChangedListeners.add(listener);
    }
    public void addRoadChangedListener(RoadChangedListener listener) {
        roadChangedListeners.add(listener);
    }

    public Building getSelectedBuilding() {
        return selectedBuilding;
    }

    public void setSelectedBuilding(Building selectedBuilding) {
        this.selectedBuilding = selectedBuilding;
    }

    private void togglePathEditMode() {
        pathEditMode =! pathEditMode;
        if (pathEditMode) {
            editButton.setText("Stop Adding Paths");
            Road r = new Road();
            selectedRoad = r;
            roads.add(r);
            previewRoad = true;
        } else {
            editButton.setText("Add Path");
            if (selectedRoad != null) {
                roads.remove(selectedRoad);
                selectedRoad = null;
                canvas.display();
            }
        }
        selectedBuilding = null;
    }

    private Road getRoadClickedOn(Vector3D startPoint, Vector3D direction) {
        Vector3D currentPlaneIntersectionPoint = Util.getIntersectionPoint(startPoint, direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);
        for (Road road : roads) {
            if (road.containsPoint(currentPlaneIntersectionPoint)) {
                return road;
            }
        }
        return null;
    }

    private void setupCanvasListeners(GLCanvas glcanvas) {
        final int[] lastMouseCoords = new int[2];

        RendererPanel self = this;

        glcanvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                double deltaX = lastMouseCoords[0] - e.getX();
                double deltaY = lastMouseCoords[1] - e.getY();

                if (self.draggingModeMove) {
                    Pair<Vector3D, Vector3D> ray = self.getClickRay(e.getX(), e.getY());
                    Vector3D direction = ray.getValue();
                    Vector3D startPoint = ray.getKey();

                    Vector3D currentPlaneIntersectionPoint = Util.getIntersectionPoint(startPoint.subtract(new Vector3D(0, originalBuildingIntersectionHeight, 0)), direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

                    double deltaXPlane = self.originalPlaneIntersectionPoint.getX() - currentPlaneIntersectionPoint.getX();
                    double deltaYPlane = self.originalPlaneIntersectionPoint.getZ() - currentPlaneIntersectionPoint.getZ();

                    if (!e.isShiftDown()) {
                        deltaXPlane = (int) deltaXPlane;
                        deltaYPlane = (int) deltaYPlane;
                    } else {
                        deltaXPlane *= 20;
                        deltaYPlane *= 20;
                        deltaXPlane = (int) deltaXPlane;
                        deltaYPlane = (int) deltaYPlane;
                        deltaXPlane /= 20;
                        deltaYPlane /= 20;
                    }

                    Vector3D newTranslation = self.originalBuildingTranslation.add(new Vector3D(-deltaXPlane, 0, -deltaYPlane));
                    self.selectedBuilding.setTranslation(newTranslation);

                } else if (self.draggingModeRotate) {
                    Pair<Vector3D, Vector3D> ray = self.getClickRay(e.getX(), e.getY());
                    Vector3D direction = ray.getValue();
                    Vector3D startPoint = ray.getKey();

                    Vector3D currentPlaneIntersectionPoint = Util.getIntersectionPoint(startPoint, direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

                    currentPlaneIntersectionPoint = currentPlaneIntersectionPoint.subtract(self.selectedBuilding.getCentrumOnPlane());
                    Vector3D originalPlaneIntersectionPoint = self.originalPlaneIntersectionPoint.subtract(self.selectedBuilding.getCentrumOnPlane());

                    double angleOriginal = Math.atan2(
                            currentPlaneIntersectionPoint.getZ(),
                            currentPlaneIntersectionPoint.getX());

                    double angleNew = Math.atan2(
                            originalPlaneIntersectionPoint.getZ(),
                            originalPlaneIntersectionPoint.getX());

                    double deltaAngle = angleNew - angleOriginal;

                    if (!e.isShiftDown()) {
                        deltaAngle /= Math.PI;
                        deltaAngle *= 32;
                        deltaAngle = (int) deltaAngle;
                        deltaAngle /= 32;
                        deltaAngle *= Math.PI;
                    } else {
                        deltaAngle /= Math.PI;
                        deltaAngle *= 256;
                        deltaAngle = (int) deltaAngle;
                        deltaAngle /= 256;
                        deltaAngle *= Math.PI;
                    }

                    self.selectedBuilding.setRotationAngle(self.originalBuildingRotation + deltaAngle);
                } else if (!e.isControlDown() && !SwingUtilities.isMiddleMouseButton(e)) {
                    double factor = .1;
                    if (e.isShiftDown()) {
                        factor = .02;
                    }
                    self.xAngle += factor * deltaX;
                    self.yAngle += factor * deltaY;
                } else {
                    double cameraHeight = Math.abs(self.position.getY());
                    double factor = .001 * cameraHeight * 1.4;
                    if (e.isShiftDown()) {
                        factor = .0002;
                    }
                    double angle = self.xAngle * Math.PI / 180;
                    self.position = self.position.add(new Vector3D(
                            Math.cos(angle) * deltaX - Math.sin(angle) * deltaY,
                            0,
                            Math.sin(angle) * deltaX + Math.cos(angle) * deltaY
                    ).scalarMultiply(factor));
                }
                lastMouseCoords[0] = e.getX();
                lastMouseCoords[1] = e.getY();

                Pair<Vector3D, Vector3D> ray = getClickRay(e.getX(), e.getY());
                liveDirection = ray.getValue();
                liveStartPoint = ray.getKey();
                livePlaneIntersectionPoint = Util.getIntersectionPoint(liveStartPoint, liveDirection, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

                glcanvas.display();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Pair<Vector3D, Vector3D> ray = getClickRay(e.getX(), e.getY());
                liveDirection = ray.getValue();
                liveStartPoint = ray.getKey();
                livePlaneIntersectionPoint = Util.getIntersectionPoint(liveStartPoint, liveDirection, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);
                if (pathEditMode) {
                    if (previewRoad) {
                        if (livePlaneIntersectionPoint != null) {
                            selectedRoad.setStartPoint(Road.snapStartPoint(livePlaneIntersectionPoint));
                            selectedRoad.setEndPoint(Road.snapStartPoint(livePlaneIntersectionPoint).add(new Vector3D(.01, 0, 0)));
                        }
                    } else {
                        selectedRoad.setEndPoint(Road.snapEndPoint(selectedRoad.getStartPoint(), livePlaneIntersectionPoint, e.isShiftDown()));
                    }
                    glcanvas.display();
                } else if (livePlaneIntersectionPoint != null && debug) {
                    glcanvas.display();
                }
            }
        });

        glcanvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Pair<Vector3D, Vector3D> ray = self.getClickRay(e.getX(), e.getY());
                Vector3D direction = ray.getValue();
                Vector3D startPoint = ray.getKey();

                Building closestBuilding = getBuildingFromRay(startPoint, direction).getKey();
                Building oldSelected = self.selectedBuilding;
                Road oldSelectedRoad = selectedRoad;
                if (closestBuilding != null) {
                    self.selectedBuilding = closestBuilding;
                } else {
                    if (!pathEditMode) {
                        self.selectedBuilding = null;
                        Road road = getRoadClickedOn(startPoint, direction);
                        selectedRoad = road;
                    }
                }

                if (pathEditMode) {
                    selectedBuilding = null;
                    if (previewRoad) {
                        roads.remove(selectedRoad);
                        selectedRoad = null;
                    }
                    previewRoad = false;
                    Vector3D planeIntersectionPoint = Util.getIntersectionPoint(startPoint, direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);
                    if (selectedRoad != null) {
                        selectedRoad.setEndPoint(Road.snapEndPoint(selectedRoad.getStartPoint(), planeIntersectionPoint, e.isShiftDown()));
                        emitRoadEvent(selectedRoad, RoadChangeType.ADD);
                    }
                    Vector3D roadStartPoint = Road.snapStartPoint(planeIntersectionPoint);
                    if (selectedRoad != null) {
                        roadStartPoint = selectedRoad.getEndPoint();
                    }

                    Road r = new Road();
                    r.setStartPoint(roadStartPoint);
                    r.setEndPoint(roadStartPoint.add(Vector3D.PLUS_I));
                    roads.add(r);
                    selectedRoad = r;

                }

                if (oldSelected != selectedBuilding || oldSelectedRoad != selectedRoad) {
                    glcanvas.display();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Pair<Vector3D, Vector3D> ray = self.getClickRay(e.getX(), e.getY());
                Vector3D direction = ray.getValue();
                Vector3D startPoint = ray.getKey();

                Pair<Building, Double> res = getBuildingFromRay(startPoint, direction);
                Building closestBuilding = res.getKey();
                double distance = res.getValue();

                self.originalPlaneIntersectionPoint = Util.getIntersectionPoint(startPoint, direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

                if (closestBuilding == self.selectedBuilding && self.selectedBuilding != null) {
                    self.draggingModeMove = true;
                    self.originalBuildingTranslation = closestBuilding.getTranslation();

                    // calculate the height of where we intersect the building
                    double height = startPoint.add(direction.normalize().scalarMultiply(distance)).getY();
                    originalBuildingIntersectionHeight = height;
                    originalPlaneIntersectionPoint = Util.getIntersectionPoint(startPoint.subtract(new Vector3D(0, height, 0)), direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

                } else if (self.selectedBuilding != null && self.selectedBuilding.isHittingRotationRing(startPoint, direction)) {
                    self.draggingModeRotate = true;
                    self.originalBuildingRotation = self.selectedBuilding.getRotationAngle();
                }

                lastMouseCoords[0] = e.getX();
                lastMouseCoords[1] = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (self.draggingModeRotate || self.draggingModeMove) {
                    emitBuildingEvent(selectedBuilding, BuildingChangeType.MOVED);
                }

                self.draggingModeMove = false;
                self.draggingModeRotate = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        final long[] nanoTimeAtLastScroll = {0};
        final double[] scrollSinceLast = {0};

        glcanvas.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                long time = System.nanoTime();
                long delta = time - nanoTimeAtLastScroll[0];
                if (delta > Math.max(17000000, 2 * lastFrameRenderTimes[(lastFrameRenderTimesIndex) % lastFrameRenderTimes.length])) {
                    nanoTimeAtLastScroll[0] = time;
                    double factor = 0.2;

                    if (e.isShiftDown()) {
                        factor = 0.03;
                    } else if (e.isAltDown()) {
                        factor = 2;
                    }

                    RealMatrix rotation = getCurrentRotationMatrix();

                    if (delta > 2000000000) {
                        scrollSinceLast[0] = 0;
                    }
                    double scroll = scrollSinceLast[0] + e.getPreciseWheelRotation();
                    scrollSinceLast[0] = 0;

                    Vector3D movement = new Vector3D(0, 0, scroll * factor);
                    movement = Util.preMultiplyVector3dMatrix(movement, rotation);
                    self.position = self.position.add(movement);
                    glcanvas.display();
                } else {
                    scrollSinceLast[0] += e.getPreciseWheelRotation();
                }
            }
        });

        glcanvas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.isShiftDown() && e.getExtendedKeyCode() == 68) { // shift + d
                    self.debug =! self.debug;
                    glcanvas.display();
                }

                if (e.getExtendedKeyCode() == 127 || e.getExtendedKeyCode() == 8) { // delete
                    if (selectedBuilding != null) {
                        buildings.remove(selectedBuilding);
                        emitBuildingEvent(selectedBuilding, BuildingChangeType.DELETED);
                        selectedBuilding = null;
                        draggingModeMove = false;
                        draggingModeRotate = false;
                        canvas.display();
                    }
                    if (selectedRoad != null) {
                        emitRoadEvent(selectedRoad, RoadChangeType.REMOVE);
                        roads.remove(selectedRoad);
                        selectedRoad = null;
                        canvas.display();
                    }
                }

                if (e.getExtendedKeyCode() == 71) { // G
                    if (selectedBuilding != null) {
                        emitBuildingEvent(selectedBuilding, BuildingChangeType.REGENERATE_REQUESTED);
                    }
                }

                if (e.getExtendedKeyCode() == 27) { // esc
                    if (pathEditMode && selectedRoad != null) {
                        roads.remove(selectedRoad);
                        selectedRoad = null;
                        canvas.display();

                        Road r = new Road();
                        roads.add(r);
                        selectedRoad = r;
                        previewRoad = true;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void display(GLAutoDrawable drawable) {

        long timeStart = System.nanoTime();

        final GL2 gl = drawable.getGL().getGL2();

        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);

        gl.glEnable(gl.GL_DEPTH_TEST);

        gl.glLoadIdentity();


        float[] lightPos = { 0, 0,0,1 };        // light position
        float[] noAmbient = { 0, 0, 0, 1f };     // low ambient light
        float[] diffuse = { .4f, .4f, .4f, 1f };        // full diffuse colour
        float[] specular = { 1f, 1f, 1f, 1f };        // full diffuse colour

        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_NORMALIZE);
        gl.glColorMaterial(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION);
        gl.glMaterialiv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, new int[]{1, 1, 1, 1}, 0);
        gl.glMaterialiv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, new int[]{0, 0, 0, 1}, 0);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, noAmbient, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION,lightPos, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR,specular, 0);


        // add blue sky
        gl.glShadeModel(gl.GL_SMOOTH);
        gl.glColor3d(135 / 255.0, 206 / 255.0, 235 / 255.0);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(-RENDER_DISTANCE, RENDER_DISTANCE / 2, -RENDER_DISTANCE + 10);
        gl.glVertex3d(RENDER_DISTANCE, RENDER_DISTANCE / 2, -RENDER_DISTANCE + 10);
        gl.glColor3d(0 / 255.0, 28 / 255.0, 124 / 255.0);
        gl.glVertex3d(RENDER_DISTANCE, -RENDER_DISTANCE / 2, -RENDER_DISTANCE + 10);
        gl.glVertex3d(-RENDER_DISTANCE, -RENDER_DISTANCE / 2, -RENDER_DISTANCE + 10);
        gl.glEnd();


        gl.glRotated(yAngle, 1.0f, 0.0f, 0.0f);
        gl.glRotated(xAngle, 0.0f, 1.0f, 0.0f);
        gl.glTranslated(-position.getX(), -position.getY(), -position.getZ());


        // add the ground
        gl.glColor3d(185 / 255.0, 180 / 255.0, 171 / 255.0);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(position.getX() - RENDER_DISTANCE, -.1, position.getZ() - RENDER_DISTANCE);
        gl.glVertex3d(position.getX() + RENDER_DISTANCE, -.1, position.getZ() - RENDER_DISTANCE);
        gl.glVertex3d(position.getX() + RENDER_DISTANCE, -.1, position.getZ() + RENDER_DISTANCE);
        gl.glVertex3d(position.getX() - RENDER_DISTANCE, -.1, position.getZ() + RENDER_DISTANCE);
        gl.glEnd();


        for (Building building : buildings) {
            building.draw(gl, building == selectedBuilding, debug, position);
        }
        for (Road road : roads) {
            road.draw(gl, road == selectedRoad, debug);
        }

        gl.glPushMatrix();
        gl.glColor3d(0.8, 0.8, 0.8);
        gl.glLineWidth(2);
        int x = (int)position.getX() - ((int)position.getX() % GRID_SIZE);
        int z = (int)position.getZ() - ((int)position.getZ() % GRID_SIZE);
        for (int i = -RENDER_DISTANCE; i <= RENDER_DISTANCE; i+= GRID_SIZE) {
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3d(x - RENDER_DISTANCE, -.05, z + i);
            gl.glVertex3d(x + RENDER_DISTANCE, -.05, z + i);
            gl.glEnd();

            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3d(x + i, -.05, z - RENDER_DISTANCE);
            gl.glVertex3d(x + i, -.05, z + RENDER_DISTANCE);
            gl.glEnd();
        }
        gl.glPopMatrix();

        if (debug && livePlaneIntersectionPoint != null) {
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3d(livePlaneIntersectionPoint.getX(), 0, livePlaneIntersectionPoint.getZ());
            gl.glVertex3d(livePlaneIntersectionPoint.getX(), position.getY() + RENDER_DISTANCE, livePlaneIntersectionPoint.getZ());
            gl.glEnd();
        }

        if (debug) {
            // axes
            gl.glLineWidth(8);
            gl.glColor3d(1, 0, 0);
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3d(position.getX() - RENDER_DISTANCE, 0, 0);
            gl.glVertex3d(position.getX() + RENDER_DISTANCE, 0, 0);
            gl.glEnd();
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3d(0, position.getY() - RENDER_DISTANCE, 0);
            gl.glVertex3d(0, position.getY() + RENDER_DISTANCE, 0);
            gl.glEnd();
            gl.glColor3d( 0, 0, 1);
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3d(0, 0, position.getZ() - RENDER_DISTANCE);
            gl.glVertex3d(0, 0, position.getZ() + RENDER_DISTANCE);
            gl.glEnd();
            gl.glLineWidth(2);

            int fontSize = 16;
            TextRenderer textRenderer = new TextRenderer(new Font("Courier", Font.PLAIN, fontSize));
            textRenderer.beginRendering((int) width, (int) height);
            textRenderer.setColor(Color.YELLOW);
            textRenderer.setSmoothing(true);

            int fps = getFps();
            String[] linesToDump = new String[] {
                    String.format("%d FPS", fps),
                    String.format("Camera Position            : %s", position),
                    String.format("Cursor Ray Direction       : %s", liveDirection),
                    String.format("Cursor Ground Intersection : %s", livePlaneIntersectionPoint)
            };
            for (int i = 0; i < linesToDump.length; i++) {
                textRenderer.draw(linesToDump[i], (int) 10, (int) height - 10 - 12 - fontSize * i);
            }
            textRenderer.endRendering();
        }

        gl.glFlush();

        long deltaTime = System.nanoTime() - timeStart;
        lastFrameRenderTimes[(lastFrameRenderTimesIndex++) % lastFrameRenderTimes.length] = deltaTime;

        // Restore original (no-) translation and rotation
        gl.glLoadIdentity();

        renderCompass(gl);


    }

    private void renderCompass(GL2 gl) {
        gl.glClear(GL2.GL_DEPTH_BUFFER_BIT);

        // Render compass
        gl.glColor3d(0, 0, 0);
        gl.glLineWidth(4);
        gl.glBegin(GL2.GL_POLYGON);
        double outerRadius = 1;
        double innerRadius = outerRadius * 0.9;

        double[] wcoord = new double[4];
        int pixelX = 50;
        int pixelY = 50;
        glu.gluUnProject((double) pixelX, (double) pixelY, 1.0, mvmatrix, 0, projmatrix, 0, viewport, 0, wcoord, 0);
        Vector3D center = new Vector3D(wcoord[0], wcoord[1], wcoord[2]).normalize().scalarMultiply(30);

        double x = center.getX(), y = center.getY(), z = center.getZ();
        int sections = 20;
        gl.glVertex3d(x, y, z);
        for (int i = 0; i <= sections; i++) {
            Vector2D newPoint = new Vector2D(
                    x + (outerRadius * Math.cos(i / (double)sections * (Math.PI * 2))),
                    y + (outerRadius * Math.sin(i / (double)sections * (Math.PI * 2)))
            );
            gl.glVertex3d(newPoint.getX(), newPoint.getY(), z);
        }
        gl.glEnd();

        gl.glClear(GL2.GL_DEPTH_BUFFER_BIT);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3d(0.9, 0.9, 0.9);
        gl.glVertex3d(x, y, z);
        for (int i = 0; i <= sections; i++) {
            Vector2D newPoint = new Vector2D(
                    x + (innerRadius * Math.cos(i / (double)sections * (Math.PI * 2))),
                    y + (innerRadius * Math.sin(i / (double)sections * (Math.PI * 2)))
            );
            gl.glVertex3d(newPoint.getX(), newPoint.getY(), z);
        }
        gl.glEnd();

        RealMatrix currentRotation = getCurrentRotationMatrix();
        currentRotation = MatrixUtils.inverse(currentRotation);
        Vector3D xDirection = Util.preMultiplyVector3dMatrix(new Vector3D(1, 0, 0), currentRotation).scalarMultiply(innerRadius * 0.9);
        Vector3D yDirection = Util.preMultiplyVector3dMatrix(new Vector3D(0, 1, 0), currentRotation).scalarMultiply(innerRadius * 0.9);
        Vector3D zDirection = Util.preMultiplyVector3dMatrix(new Vector3D(0, 0, -1), currentRotation).scalarMultiply(innerRadius * 0.9);


        // X
        gl.glColor3d(1, 0, 0);
        gl.glClear(GL2.GL_DEPTH_BUFFER_BIT);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3d(x, y, z);
        gl.glVertex3d(x + xDirection.getX() , y + xDirection.getY(), z + xDirection.getZ());
        gl.glEnd();

        // Y
        gl.glColor3d(0, 1, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3d(x, y, z);
        gl.glVertex3d(x + yDirection.getX() , y + yDirection.getY(), z + yDirection.getZ());
        gl.glEnd();

        // Z
        gl.glColor3d(0, 0, 1);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3d(x, y, z);
        gl.glVertex3d(x + zDirection.getX() , y + zDirection.getY(), z + zDirection.getZ());
        gl.glEnd();
    }

    private int getFps() {
        int validCounts = 0;
        long totalTime = 0;
        for (int i = 0; i < lastFrameRenderTimes.length; i++) {
            if (lastFrameRenderTimes[i] != 0) {
                totalTime += lastFrameRenderTimes[i];
                validCounts += 1;
            }
        }
        int fps;
        if (validCounts != 0) {
            fps = (int) Math.ceil(validCounts * 1e9 / totalTime);
        } else {
            fps = 60;
        }
        return fps;
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        //method body
    }

    @Override
    public void init(GLAutoDrawable arg0) {
        // method body
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = (GL2) drawable.getGL();

        height = (height == 0) ? 1 : height; // prevent divide by zero
        float aspect = (float)width / height;

        // Set the current view port to cover full screen
        gl.glViewport(0, 0, width, height);

        // Set up the projection matrix - choose perspective view
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity(); // reset
        // Angle of view (fovy) is 45 degrees (in the up y-direction). Based on this
        // canvas's aspect ratio. Clipping z-near is 0.1f and z-near is 100.0f.
        fovY = 50.0;
        fovX = fovY * aspect;
        this.width = width / 2;
        this.height = height / 2;

        if (canvas != null) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
        }
        glu.gluPerspective(fovY, aspect, 1f, RENDER_DISTANCE); // fovy, aspect, zNear, zFar

        // Enable the model-view transform
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity(); // reset

        this.viewport = new int[4];
        this.mvmatrix = new double[16];
        this.projmatrix = new double[16];

        gl.glGetIntegerv(GL.GL_VIEWPORT, viewport, 0);
        gl.glGetDoublev(GL2.GL_MODELVIEW_MATRIX, mvmatrix, 0);
        gl.glGetDoublev(GL2.GL_PROJECTION_MATRIX, projmatrix, 0);

        this.viewport[2] = canvas.getWidth();
        this.viewport[3] = canvas.getHeight();

    }

    public void addBuilding(Building building) {
        if (this.buildings == null) {
            this.buildings = new ArrayList<Building>();
        }
        this.buildings.add(building);
    }

    public void addRoad(Road road) {
        if (this.roads == null) {
            this.roads = new ArrayList<>();
        }
        this.roads.add(road);
    }

    public RealMatrix getCurrentRotationMatrix() {
        RealMatrix rotationYAxis = Util.createRotationMatrix((yAngle) / 180 * Math.PI, Vector3D.PLUS_I);
        RealMatrix rotationXAxis = Util.createRotationMatrix((xAngle) / 180 * Math.PI, Vector3D.PLUS_J);
        RealMatrix rotation = rotationYAxis.multiply(rotationXAxis);

        return rotation;
    }

    public Pair<Vector3D, Vector3D> getClickRay(int pixelX, int pixelY) {
        RealMatrix rotation = getCurrentRotationMatrix();

        double[] wcoord = new double[4];
        glu.gluUnProject((double) pixelX, (double) (height - pixelY), 1.0, mvmatrix, 0, projmatrix, 0, viewport, 0, wcoord, 0);

        Vector3D direction = Util.preMultiplyVector3dMatrix(new Vector3D(wcoord[0], wcoord[1], wcoord[2]), rotation);
        direction = direction.normalize();

        Vector3D startPoint = position;

        return new Pair<>(startPoint, direction);
    }

    private Pair<Building, Double> getBuildingFromRay(Vector3D startPoint, Vector3D direction) {
        Building closestBuilding = null;
        double closestDistance = Double.MAX_VALUE;
        for (Building building : buildings) {
            double distance = building.getClosestHit(startPoint, direction);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestBuilding = building;
            }
        }
        return new Pair<>(closestBuilding, closestDistance);
    }

    private void emitBuildingEvent(Building b, BuildingChangeType type) {
        for (BuildingChangedListener listener : buildingChangedListeners) {
            listener.buildingChanged(b, type);
        }
    }

    private void emitRoadEvent(Road r, RoadChangeType type) {
        for (RoadChangedListener listener : roadChangedListeners) {
            listener.roadChanged(r, type);
        }
    }

    public void forceRedraw() {
        canvas.display();
    }

    public void clearSelection() {
        this.selectedBuilding = null;
    }

    public void clearAllBuildings() {
        this.buildings = new ArrayList<>();
        this.selectedBuilding = null;
        this.draggingModeMove = false;
        this.draggingModeRotate = false;
    }
}
