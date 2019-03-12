package graphics;

import figures.lines.Line;
import figures.lines.PolyLine;
import figures.lines.Ray;
import figures.Shape;
import figures.lines.Segment;
import utils.DrawAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    private static ArrayList<Point> points;
    private ArrayList<Shape> figures;
    private Shape curFigure;

    public DrawPanel() {
        setPreferredSize(new Dimension(900, 700));
        setFocusable(true);
        setBackground(Color.white);
        points = new ArrayList<>();
        figures = new ArrayList<>();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                points.add(e.getPoint());
                switch (App.getMode()) {
                    case MOVE:
                        for (Shape figure : figures) {
                            if (figure.contains(e.getPoint())) {
                                curFigure = figure;
                                break;
                            }
                        }
                        clearPoints();
                        break;
                    case SEGMENT:
                        if (points.size() == 2) {
                            figures.add(new Segment(points.get(0), points.get(1), MenuPanel.getCurrentColor()));
                            clearPoints();
                        }
                        break;
                    case RAY:
                        if (points.size() == 2) {
                            figures.add(new Ray(points.get(0), points.get(1), MenuPanel.getCurrentColor()));
                            clearPoints();
                        }
                        break;
                    case LINE:
                        if (points.size() == 2) {
                            figures.add(new Line(points.get(0), points.get(1), MenuPanel.getCurrentColor()));
                            clearPoints();
                        }
                        break;
                    case POLYLINE:
                        if (points.size() == 1) {
                            figures.add(new PolyLine(points.get(0), MenuPanel.getCurrentColor()));
                        } else {
                            PolyLine polyLine = (PolyLine) figures.get(figures.size() - 1);
                            polyLine.addSegment(points.get(points.size() - 1), MenuPanel.getCurrentColor());
                        }
                        break;
                }
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (App.getMode() == DrawAction.MOVE && curFigure != null) {
                    curFigure.move(e.getPoint());
                    repaint();
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(MenuPanel.getCurrentColor());
        points.forEach(point -> g.fillRect(point.x, point.y, 4, 4));
        figures.forEach(figure -> {
            g.setColor(figure.getLineColor());
            figure.draw(g);
        });
    }

    public static void clearPoints() {
        points.clear();
    }
}
