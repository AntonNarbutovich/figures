package figures.lines;

import figures.lines.Ray;

import java.awt.*;

public class Line extends Ray {
    public Line(Point theCenter, Point secondPoint, Color lineColor) {
        super(theCenter, secondPoint, lineColor);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getLineColor());
        g.drawLine(getOutPoint(getTheCenter(), getSecondPoint()).x, getOutPoint(getTheCenter(), getSecondPoint()).y,
                getOutPoint(getSecondPoint(), getTheCenter()).x, getOutPoint(getSecondPoint(), getTheCenter()).y);
    }

    @Override
    public void move(Point p) {

    }

}
