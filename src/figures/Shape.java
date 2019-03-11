package figures;

import java.awt.*;

public abstract class Shape {
    private Point theCenter;
    private Color lineColor;

    public Shape(Point theCenter, Color lineColor) {
        this.theCenter = theCenter;
        this.lineColor = lineColor;
    }

    public Point getTheCenter() {
        return theCenter;
    }

    public void setTheCenter(Point theCenter) {
        this.theCenter = theCenter;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public abstract void draw(Graphics g);

    public abstract void move(Point p);

    public abstract boolean contains(Point p);

}
