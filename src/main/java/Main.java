import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javafx.util.Pair;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.linear.RealMatrix;


import javax.swing.JFrame;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main implements GLEventListener {
    private static GLU glu;
    List<Building> buildings;

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
            gl.glColor3d( 1, 0, 0);
            gl.glBegin(GL2.GL_LINES);
            gl.glVertex3d(-100, 0, i);
            gl.glVertex3d(100, 0, i);
            gl.glEnd();


            gl.glColor3d(0, 0, 1);
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

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/madsbjoern/Desktop/house.jbuild");
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        glu = new GLU();

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        final Main l = new Main();
        //p.rotate(Axis3D.Y, -Math.PI / 4);
        //p.translate(new Vector3D(0.5, 0, 0));
        //p.scale(new Vector2D(1.2, 0.8));
        //final Shape pp = p;
        //l.addShapes(new ArrayList<Shape>(){{add(pp);}});
        //List<Shape> shapes = new ArrayList<>();
        //shapes.add(p);
        //shapes.addAll(shapes.get(0).split(Axis2D.Y, new UnitLength[]{new UnitLength(0.33, Unit.PERCENTAGE), new UnitLength(0.33, Unit.PERCENTAGE), new UnitLength(0.33, Unit.PERCENTAGE)}, true, false));
        //shapes.remove(0);
        //int middlePartIndex = 1;
        //shapes.addAll(shapes.get(middlePartIndex).extrude(.2));
        //shapes.remove(middlePartIndex);

        //shapes.get(0).setColor(Color.green);
        /*
        shapes.get(1).translate(new Vector3D(0, .2, 0));
        shapes.get(1).rotate(Vector3D.PLUS_I, -Math.PI / 2);
        shapes.get(1).scale(new Vector2D(1.1, 1));
        shapes.get(1).translate(new Vector3D(-0.025, 0, -.022));
        shapes.addAll(shapes.get(1).extrude(0.2475 + .025*2));
        shapes.remove(1);

         */

        Building b1 = Building.buildFromFile(file);
        Building b2 = new Building(b1.getAst());
        Building b3 = new Building(b1.getAst());
        Building b4 = new Building(b1.getAst());

        b2.setTranslation(new Vector3D(0, 0, -10));
        b2.setRotationAngle(-Math.PI / 4);

        b3.setTranslation(new Vector3D(10, 0, 0));
        b3.setRotationAngle(-Math.PI / 4);

        b4.setTranslation(new Vector3D(10, 0, -10));
        b4.setRotationAngle(6.7 * Math.PI / 4);

        l.addBuilding(b1);
        l.addBuilding(b2);
        l.addBuilding(b3);
        l.addBuilding(b4);
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(1600, 900);

        //creating frame
        final JFrame frame = new JFrame ("Triangle");

        frame.getContentPane().add(glcanvas);

        final int[] lastMouseCoords = new int[2];

        glcanvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                double deltaX = lastMouseCoords[0] - e.getX();
                double deltaY = lastMouseCoords[1] - e.getY();

                if (l.draggingModeMove) {
                    Pair<Vector3D, Vector3D> ray = l.getClickRay(e.getX(), e.getY());
                    Vector3D direction = ray.getValue();
                    Vector3D startPoint = ray.getKey();

                    Vector3D currentPlaneIntersectionPoint = Util.getIntersectionPoint(startPoint, direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

                    double deltaXPlane = l.originalPlaneIntersectionPoint.getX() - currentPlaneIntersectionPoint.getX();
                    double deltaYPlane = l.originalPlaneIntersectionPoint.getZ() - currentPlaneIntersectionPoint.getZ();

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

                    Vector3D newTranslation = l.originalBuildingTranslation.add(new Vector3D(-deltaXPlane, 0, -deltaYPlane));
                    l.selectedBuilding.setTranslation(newTranslation);

                } else if (l.draggingModeRotate) {
                    Pair<Vector3D, Vector3D> ray = l.getClickRay(e.getX(), e.getY());
                    Vector3D direction = ray.getValue();
                    Vector3D startPoint = ray.getKey();

                    Vector3D currentPlaneIntersectionPoint = Util.getIntersectionPoint(startPoint, direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

                    currentPlaneIntersectionPoint = currentPlaneIntersectionPoint.subtract(l.selectedBuilding.getCentrumOnPlane());
                    Vector3D originalPlaneIntersectionPoint = l.originalPlaneIntersectionPoint.subtract(l.selectedBuilding.getCentrumOnPlane());

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

                    l.selectedBuilding.setRotationAngle(l.originalBuildingRotation + deltaAngle);
                } else if (!e.isControlDown()) {
                    double factor = .1;
                    if (e.isShiftDown()) {
                        factor = .02;
                    }
                    l.xAngle += factor * deltaX;
                    l.yAngle += factor * deltaY;
                } else {
                    double cameraHeight = Math.abs(l.position.getY());
                    double factor = .001 * cameraHeight * 1.4;
                    if (e.isShiftDown()) {
                        factor = .0002;
                    }
                    double angle = l.xAngle * Math.PI / 180;
                    l.position = l.position.add(new Vector3D(
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
                Pair<Vector3D, Vector3D> ray = l.getClickRay(e.getX(), e.getY());
                Vector3D direction = ray.getValue();
                Vector3D startPoint = ray.getKey();

                Building closestBuilding = l.getBuildingFromRay(startPoint, direction);
                Building oldSelected = l.selectedBuilding;
                if (closestBuilding != null) {
                    l.selectedBuilding = closestBuilding;
                } else {
                    l.selectedBuilding = null;
                }
                if (oldSelected != l.selectedBuilding) {
                    glcanvas.display();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Pair<Vector3D, Vector3D> ray = l.getClickRay(e.getX(), e.getY());
                Vector3D direction = ray.getValue();
                Vector3D startPoint = ray.getKey();

                Building closestBuilding = l.getBuildingFromRay(startPoint, direction);

                l.originalPlaneIntersectionPoint = Util.getIntersectionPoint(startPoint, direction, Vector3D.ZERO, Vector3D.PLUS_I, Vector3D.PLUS_K);

                if (closestBuilding == l.selectedBuilding && l.selectedBuilding != null) {
                    l.draggingModeMove = true;
                    l.originalBuildingTranslation = closestBuilding.getTranslation();
                } else if (l.selectedBuilding != null && l.selectedBuilding.isHittingRotationRing(startPoint, direction)) {
                    l.draggingModeRotate = true;
                    l.originalBuildingRotation = l.selectedBuilding.getRotationAngle();
                }

                lastMouseCoords[0] = e.getX();
                lastMouseCoords[1] = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                l.draggingModeMove = false;
                l.draggingModeRotate = false;
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
                    }

                    RealMatrix rotationXAxis = Util.createRotationMatrix(l.xAngle / 180 * Math.PI, Vector3D.PLUS_J);
                    RealMatrix rotationYAxis = Util.createRotationMatrix(l.yAngle / 180 * Math.PI, Vector3D.PLUS_I);
                    RealMatrix rotation = rotationYAxis.multiply(rotationXAxis);

                    if (delta > 2000000000) {
                        scrollSinceLast[0] = 0;
                    }
                    double scroll = scrollSinceLast[0] + e.getPreciseWheelRotation();
                    scrollSinceLast[0] = 0;

                    Vector3D movement = new Vector3D(0, 0, scroll * factor);
                    movement = Util.preMultiplyVector3dMatrix(movement, rotation);
                    l.position = l.position.add(movement);
                    glcanvas.display();
                } else {
                    scrollSinceLast[0] += e.getPreciseWheelRotation();
                }
            }
        });

        glcanvas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.isShiftDown() && e.getExtendedKeyCode() == 68) { // shift + d
                    l.debug =! l.debug;
                    System.out.println("s" + l.debug);
                    glcanvas.display();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        frame.requestFocus();

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
}
