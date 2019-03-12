package figures.shape2D;

import java.awt.*;
import java.util.ArrayList;

public class Polygon2D extends Shape2D{
    private ArrayList<Point> points;

    public Polygon2D(Point theCenter, Color lineColor, Color theFill, ArrayList<Point> points) {
        super(theCenter, lineColor, theFill);
        this.points = points;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    private int[] getXPoints() {
        int n = points.size();
        int[] xPoints = new int[n];
        for (int i = 0; i < n; i++) {
            xPoints[i] = (int)points.get(i).getX();
        }
        return xPoints;
    }

    private int[] getYPoints() {
        int n = points.size();
        int[] yPoints = new int[n];
        for (int i = 0; i < n; i++) {
            yPoints[i] = (int)points.get(i).getY();
        }
        return yPoints;
    }

    @Override
    public void draw(Graphics g) {
        int n = points.size();
        int[] xPoints = getXPoints();
        int[] yPoints = getYPoints();
        g.setColor(getLineColor());
        g.drawPolygon(xPoints, yPoints, n);
        g.setColor(getTheFill());
        g.fillPolygon(xPoints, yPoints, n);
    }

    @Override
    public void move(Point p) { //Point p - новый центр полигона (хотя я не знаю что такое центр полигона)
        setTheCenter(p);
        ArrayList<Point> newPoints = new ArrayList<>();
        for (Point point: points) {
            Point newPoint = new Point((int) (point.getX() + p.getX() - getTheCenter().getX()),
                    (int) (point.getY() + p.getY() - getTheCenter().getY()));
            newPoints.add(newPoint);
        }
        setPoints(newPoints);
    }

    @Override
    public boolean contains(Point p) {
        int n = points.size();
        int[] xPoints = getXPoints();
        int[] yPoints = getYPoints();
        Polygon polygon = new Polygon(xPoints, yPoints, n);
        return polygon.contains(p);
    }
}
