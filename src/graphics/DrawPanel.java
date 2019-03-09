package graphics;

import figures.Shape;
import figures.Segment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    private static ArrayList<Point> points;
    private ArrayList<Shape> figures;

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
                    case SEGMENT:
                        if (points.size() == 2) {
                            figures.add(new Segment(points.get(0), points.get(1), MenuPanel.getCurrentColor()));
                            clearPoints();
                        }
                        break;
                    case RAY:

                        break;
                }
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(MenuPanel.getCurrentColor());
        points.forEach(point -> g.drawLine(point.x, point.y, point.x, point.y));
        figures.forEach(figure -> {
            g.setColor(figure.getLineColor());
            figure.draw(g);
        });
    }

    public void clearPoints() {
        points.clear();
    }
}
