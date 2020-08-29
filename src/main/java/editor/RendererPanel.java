package editor;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javafx.util.Pair;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.linear.RealMatrix;
import renderer.Building;
import renderer.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class RendererPanel extends JPanel implements GLEventListener {
    private static GLU glu;
    List<Building> buildings = new ArrayList<>();

    private double xAngle = -22.5;
    private double yAngle = 22.5;

    private Vector3D position = new Vector3D(2, 2, 2);

    private double fovX, fovY, width, height;

    private boolean debug = false;

    private Building selectedBuilding = null;

    private boolean draggingModeMove = false;
    private Vector3D originalPlaneIntersectionPoint = null;
    private Vector3D originalBuildingTranslation = null;

    private boolean draggingModeRotate = false;
    private double originalBuildingRotation = 0;

    GLCanvas canvas = null;

    private List<BuildingChangedListener> buildingChangedListeners = new ArrayList<>();

    public RendererPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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

                    Vector3D currentPlaneIntersectionPoint = Util.getIntersectionPoint(startPoint, direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

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
                        deltaAngle *= 16;
                        deltaAngle = (int) deltaAngle;
                        deltaAngle /= 16;
                        deltaAngle *= Math.PI;
                    } else {
                        deltaAngle /= Math.PI;
                        deltaAngle *= 128;
                        deltaAngle = (int) deltaAngle;
                        deltaAngle /= 128;
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
                glcanvas.display();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        glcanvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Pair<Vector3D, Vector3D> ray = self.getClickRay(e.getX(), e.getY());
                Vector3D direction = ray.getValue();
                Vector3D startPoint = ray.getKey();

                Building closestBuilding = self.getBuildingFromRay(startPoint, direction);
                Building oldSelected = self.selectedBuilding;
                if (closestBuilding != null) {
                    self.selectedBuilding = closestBuilding;
                } else {
                    self.selectedBuilding = null;
                }
                if (oldSelected != self.selectedBuilding) {
                    glcanvas.display();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Pair<Vector3D, Vector3D> ray = self.getClickRay(e.getX(), e.getY());
                Vector3D direction = ray.getValue();
                Vector3D startPoint = ray.getKey();

                Building closestBuilding = self.getBuildingFromRay(startPoint, direction);

                self.originalPlaneIntersectionPoint = Util.getIntersectionPoint(startPoint, direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

                if (closestBuilding == self.selectedBuilding && self.selectedBuilding != null) {
                    self.draggingModeMove = true;
                    self.originalBuildingTranslation = closestBuilding.getTranslation();
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
                if (delta > 17000000) {
                    nanoTimeAtLastScroll[0] = time;
                    double factor = 0.2;

                    if (e.isShiftDown()) {
                        factor = 0.03;
                    } else if (e.isAltDown()) {
                        factor = 2;
                    }

                    RealMatrix rotationXAxis = Util.createRotationMatrix(self.xAngle / 180 * Math.PI, Vector3D.PLUS_J);
                    RealMatrix rotationYAxis = Util.createRotationMatrix(self.yAngle / 180 * Math.PI, Vector3D.PLUS_I);
                    RealMatrix rotation = rotationYAxis.multiply(rotationXAxis);

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
                    System.out.println("s" + self.debug);
                    glcanvas.display();
                }

                if (e.getExtendedKeyCode() == 127) { // delete
                    if (selectedBuilding != null) {
                        buildings.remove(selectedBuilding);
                        emitBuildingEvent(selectedBuilding, BuildingChangeType.DELETED);
                        selectedBuilding = null;
                        draggingModeMove = false;
                        draggingModeRotate = false;
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
        //gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPOT_CUTOFF,new float[]{65}, 0);
        //gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPOT_DIRECTION,new float[]{0, 0, -1}, 0);


        gl.glRotated(yAngle, 1.0f, 0.0f, 0.0f);
        gl.glRotated(xAngle, 0.0f, 1.0f, 0.0f);
        gl.glTranslated(-position.getX(), -position.getY(), -position.getZ());


        //drawing the base
        for (Building building : buildings) {
            building.draw(gl, debug || building == selectedBuilding, position);
        }

        gl.glLineWidth(8);
        gl.glColor3d(1, 0, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3d(-100, 0, 0);
        gl.glVertex3d(100, 0, 0);
        gl.glEnd();
        gl.glColor3d(0, 1, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3d(0, -100, 0);
        gl.glVertex3d(0, 100, 0);
        gl.glEnd();
        gl.glColor3d( 0, 0, 1);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3d(0, 0, -100);
        gl.glVertex3d(0, 0, 100);
        gl.glEnd();

        gl.glLineWidth(2);
        for (int i = -100; i <= 100; i++) {
            gl.glColor3d( 0.1, 0, 0);
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3d(-100, 0, i);
            gl.glVertex3d(100, 0, i);
            gl.glEnd();


            gl.glColor3d( 0, 0, 0.1);
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3d(i, 0, -100);
            gl.glVertex3d(i, 0, 100);
            gl.glEnd();
        }

        gl.glFlush();

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
        glu.gluPerspective(fovY, aspect, 0.1f, 100.0f); // fovy, aspect, zNear, zFar

        // Enable the model-view transform
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity(); // reset
    }

    public void addBuilding(Building building) {
        if (this.buildings == null) {
            this.buildings = new ArrayList<Building>();
        }
        this.buildings.add(building);
    }

    public Pair<Vector3D, Vector3D> getClickRay(int pixelX, int pixelY) {
        double deltaX = (pixelX / width - .5) * fovX;
        double deltaY = (pixelY / height - .5) * fovY;


        RealMatrix rotationXAxis = Util.createRotationMatrix((xAngle + deltaX) / 180 * Math.PI, Vector3D.PLUS_J);
        RealMatrix rotationYAxis = Util.createRotationMatrix((yAngle + deltaY) / 180 * Math.PI, Vector3D.PLUS_I);
        RealMatrix rotation = rotationYAxis.multiply(rotationXAxis);

        Vector3D direction = Util.preMultiplyVector3dMatrix(Vector3D.MINUS_K, rotation);
        Vector3D startPoint = position;

        return new Pair<>(startPoint, direction);
    }

    private Building getBuildingFromRay(Vector3D startPoint, Vector3D direction) {
        Building closestBuilding = null;
        double closestDistance = Double.MAX_VALUE;
        for (Building building : buildings) {
            double distance = building.getClosestHit(startPoint, direction);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestBuilding = building;
            }
        }
        return closestBuilding;
    }

    private void emitBuildingEvent(Building b, BuildingChangeType type) {
        for (BuildingChangedListener listener : buildingChangedListeners) {
            listener.buildingChanged(b, type);
        }
    }

    public void forceRedraw() {
        canvas.display();
    }

    public void clearAllBuildings() {
        this.buildings = new ArrayList<>();
        this.selectedBuilding = null;
        this.draggingModeMove = false;
        this.draggingModeRotate = false;
    }
}
