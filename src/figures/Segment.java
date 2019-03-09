package figures;

import java.awt.*;

public class Segment extends Shape {
    private Point secondPoint;

    public Segment(Point theCenter, Point secondPoint, Color lineColor) {
        super(theCenter, lineColor);
        this.secondPoint = secondPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getLineColor());
        g.drawLine(getTheCenter().x, getTheCenter().y, getSecondPoint().x, getSecondPoint().y);
    }

    @Override
    public void move(Point p) {

    }
}
