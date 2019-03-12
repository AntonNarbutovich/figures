package figures.shape2D;

import java.awt.*;
import java.util.ArrayList;

public class SymmetricFigure extends Polygon2D {

    private int n;
    private Point secondPoint;

    public SymmetricFigure(Point theCenter, Color lineColor, Color theFill, ArrayList<Point> points, int _n, Point second) {
        super(theCenter, lineColor, theFill, points);
        n = _n;
        secondPoint = second;
        setPoints(findPoints(secondPoint, theCenter));
    }

    private ArrayList<Point> findPoints(Point sec, Point center) {
        ArrayList<Point> points = new ArrayList<>();
        int radius = (int) Math.sqrt(Math.pow(sec.x - center.x, 2) + Math.pow(sec.y - center.y, 2));
        for (int i = 0; i < n; i++) {
            points.add(new Point((int) (center.x + radius * Math.cos(2 * Math.PI * i / n)), (int) (center.y + radius * Math.sin(2 * Math.PI * i / n))));
        }
        return points;
    }

    public int getCount() {
        return n;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setCount(int _n) {
        n = _n;
    }

    public void setSecondPoint(Point second) {
        secondPoint = second;
    }

}