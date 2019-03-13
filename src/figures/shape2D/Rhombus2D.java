package figures.shape2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Rhombus2D extends Polygon2D{
    private Point vertex;

    public Rhombus2D(Point theCenter, Color lineColor, Color theFill, ArrayList<Point> points, Point vertex) {
        super(theCenter, lineColor, theFill, points);
        int width, height;
        if (theCenter.x > vertex.x){
            width = theCenter.x - Math.abs(theCenter.x - vertex.x)/2;
        }
        else
        {
            width = theCenter.x + Math.abs(theCenter.x - vertex.x)/2;
        }
        if (theCenter.y > vertex.y){
            height = theCenter.y - Math.abs(theCenter.y - vertex.y)/2;
        }
        else
        {
            height = theCenter.y + Math.abs(theCenter.y - vertex.y)/2;
        }
        ArrayList<Point> newPoints = new ArrayList<>(Arrays.asList(new Point(theCenter.x, height),
                new Point(width, vertex.y), new Point(vertex.x, height), new Point(width, theCenter.y)));
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
