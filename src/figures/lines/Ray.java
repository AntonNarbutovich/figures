package figures.lines;

import figures.lines.Segment;

import java.awt.*;

public class Ray extends Segment {
    public Ray(Point theCenter, Point secondPoint, Color lineColor) {
        super(theCenter, secondPoint, lineColor);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getLineColor());
        g.drawLine(getTheCenter().x, getTheCenter().y,
                getOutPoint(getTheCenter(), getSecondPoint()).x, getOutPoint(getTheCenter(), getSecondPoint()).y);
    }

    @Override
    public void move(Point p) {

    }

    Point getOutPoint(Point p1, Point p2) {
        Point result = new Point();
        double deltaX = p2.x - p1.x;
        double deltaY = p2.y - p1.y;
        if (deltaX==0 && deltaY==0)
            return p2;
        if (Math.abs(deltaX) < Math.abs(deltaY)) {
            double height;
            if (deltaY < 0)
                height = -1;
            else
                height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() + 1;
            result.setLocation(deltaX / deltaY * (height - p1.y) + p1.x, height);
        } else {
            double width;
            if (deltaX < 0)
                width = -1;
            else
                width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 1;
            result.setLocation(width, deltaY / deltaX * (width - p1.x) + p1.y);
        }
        return result;
    }
}
