package figures.shape2D;

import figures.Shape;

import java.awt.*;

public abstract class Shape2D extends Shape {
    private Color theFill;

    public Shape2D(Point theCenter, Color lineColor, Color theFill) {
        super(theCenter, lineColor);
        this.theFill = theFill;
    }

    public Color getTheFill() {
        return theFill;
    }

    public void setTheFill(Color theFill) {
        this.theFill = theFill;
    }
}
