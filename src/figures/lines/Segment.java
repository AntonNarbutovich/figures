package figures.lines;

import figures.Shape;

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
        setSecondPoint(new Point(getSecondPoint().x + p.x - getTheCenter().x, getSecondPoint().y + p.y - getTheCenter().y));
        setTheCenter(p);
    }

    @Override
    public boolean contains(Point p){
        double k = ((double) getTheCenter().y - (double) getSecondPoint().y)/((double) getTheCenter().x - (double) getSecondPoint().x);
        double y = k*p.x + getTheCenter().y - k*getTheCenter().x;
        int constant = 34;
        if(p.x > Math.max(getSecondPoint().x, getTheCenter().x)+ constant/2)
            return false;
        if(p.x < Math.min(getSecondPoint().x, getTheCenter().x) - constant/2)
            return false;
        if(p.y  > Math.max(getSecondPoint().y, getTheCenter().y) + constant/2)
            return false;
        if(p.y < Math.min(getSecondPoint().y, getTheCenter().y) - constant/2)
            return false;
        if(Math.abs(p.y - y) < constant)
            return true;
        else return false;
    }
}
