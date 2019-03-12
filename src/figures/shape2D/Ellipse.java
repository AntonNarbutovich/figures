package figures.shape2D;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Shape2D{
    private Point vertex;

    public Ellipse(Point theCenter, Color lineColor, Color theFill, Point vertex) {
        super(theCenter, lineColor, theFill);
        this.vertex = vertex;
    }

    public Point getVertex() {
        return vertex;
    }

    public void setVertex(Point vertex) {
        this.vertex = vertex;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double ellipse = new Ellipse2D.Double(getVertex().getX(),
                getVertex().getY(),
                2 * Math.abs(getVertex().getX() - getTheCenter().getX()),
                2 * Math.abs(getVertex().getY() - getTheCenter().getY()));

        g2.setColor(getLineColor());
        g2.draw(ellipse);
        g2.setPaint(getTheFill());
        g2.fill(ellipse);
    }

    @Override
    public void move(Point p) {
        setTheCenter(new Point((int)(getTheCenter().getX() + p.getX() - getVertex().getX()),
                (int)(getTheCenter().getY() + p.getY() - getVertex().getY())));
        setVertex(p); //Point p становится новой вершиной описанного прямоугольника
    }

    @Override
    public boolean contains(Point p) {
        Ellipse2D.Double ellipse = new Ellipse2D.Double(getVertex().getX(),
                getVertex().getY(),
                2 * Math.abs(getVertex().getX() - getTheCenter().getX()),
                2 * Math.abs(getVertex().getY() - getTheCenter().getY()));
        return ellipse.contains(p.getX(), p.getY());
    }
}
