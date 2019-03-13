package figures.shape2D;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle2D extends Polygon2D {
    private Point vertex;

    public Rectangle2D(Point theCenter, Color lineColor, Color theFill, ArrayList<Point> points, Point vertex) {
        super(theCenter, lineColor, theFill, points);
        ArrayList<Point> newPoints = new ArrayList<>(Arrays.asList(theCenter, new Point(theCenter.x, vertex.y), vertex,
                new Point(vertex.x, theCenter.y)));
        setPoints(newPoints);
        this.vertex = vertex;
    }


    public Point getVertex() {
        return vertex;
    }

    public void setVertex(Point vertex) {
        this.vertex = vertex;
    }
}
