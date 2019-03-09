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

    }

    public void addSegment(Point point, Color color){
        if(!segments.isEmpty()) {
            segments.add(new Segment(segments.get(segments.size() - 1).getSecondPoint(), point, color));
        }
        else {
            segments.add(new Segment(getTheCenter(), point, color));
        }
    }
}
