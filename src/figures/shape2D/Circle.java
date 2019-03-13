package figures.shape2D;

import figures.shape2D.Ellipse;

import java.awt.*;

public class Circle extends Ellipse {

    public Circle(Point theCenter, Color lineColor, Color theFill, Point vertex) {
        super(theCenter, lineColor, theFill, vertex);
        int dist = (int) Math.sqrt(Math.pow(vertex.x - theCenter.x, 2) + Math.pow(vertex.y - theCenter.y, 2));
        Point secondPoint = new Point(theCenter.x - dist, theCenter.y - dist);
        setVertex(secondPoint);
    }
}