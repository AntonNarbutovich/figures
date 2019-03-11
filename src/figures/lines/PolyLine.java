package figures.lines;

import figures.Shape;

import java.awt.*;
import java.util.ArrayList;

public class PolyLine extends Shape {
    ArrayList<Segment> segments;

    public PolyLine(Point theCenter, Color lineColor) {
        super(theCenter, lineColor);
        segments = new ArrayList<>();
    }

    @Override
    public void draw(Graphics g) {
        segments.forEach(segment -> segment.draw(g));
    }

    @Override
    public void move(Point p) {
        int deltaX;
        int deltaY;

        int oldSecondX = segments.get(0).getSecondPoint().x;
        int oldSecondY = segments.get(0).getSecondPoint().y;

        segments.get(0).move(p);
        for (int i = 1; i < segments.size(); i++) {

            segments.get(i).setTheCenter(segments.get(i - 1).getSecondPoint());

            deltaX = segments.get(i).getTheCenter().x - oldSecondX;
            deltaY = segments.get(i).getTheCenter().y - oldSecondY;

            oldSecondX = segments.get(i).getSecondPoint().x;
            oldSecondY = segments.get(i).getSecondPoint().y;

            segments.get(i).setSecondPoint(new Point(oldSecondX + deltaX, oldSecondY + deltaY));


        }

    }

    @Override
    public boolean contains(Point p) {
        for(Segment segment: segments){
            if(segment.contains(p)){
                return true;
            }
        }
        return false;
    }

    public void addSegment(Point point, Color color) {
        if (!segments.isEmpty()) {
            segments.add(new Segment(segments.get(segments.size() - 1).getSecondPoint(), point, color));
        } else {
            segments.add(new Segment(getTheCenter(), point, color));
        }
    }
}
