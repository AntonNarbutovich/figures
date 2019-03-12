package graphics;

import utils.DrawAction;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private ButtonGroup switchFigure;
    private JButton colorChooser;
    private static Color currentColor;

    public MenuPanel() {
        setPreferredSize(new Dimension(300, 700));
        setFocusable(true);
        setLayout(new GridLayout(20, 1));
        setButtons();
        currentColor = Color.BLACK;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void setButtons() {
        colorChooser = new JButton("Choose color");
        colorChooser.addActionListener(e -> currentColor = JColorChooser.showDialog(this, "Choose color", Color.BLACK));

        switchFigure = new ButtonGroup();
        JRadioButton moveBtn = new JRadioButton("Move");
        moveBtn.addActionListener(e -> {
            App.setMode(DrawAction.MOVE);
            DrawPanel.clearPoints();
        });
        JRadioButton segmentBtn = new JRadioButton("Segment");
        segmentBtn.addActionListener(e -> {
            App.setMode(DrawAction.SEGMENT);
            DrawPanel.clearPoints();
        });
        JRadioButton rayBtn = new JRadioButton("Ray");
        rayBtn.addActionListener(e -> {
            App.setMode(DrawAction.RAY);
            DrawPanel.clearPoints();
        });
        JRadioButton lineBtn = new JRadioButton("Line");
        lineBtn.addActionListener(e -> {
            App.setMode(DrawAction.LINE);
            DrawPanel.clearPoints();
        });
        JRadioButton polylineBtn = new JRadioButton("Polyline");
        polylineBtn.addActionListener(e -> {
            App.setMode(DrawAction.POLYLINE);
            DrawPanel.clearPoints();
        });
        JRadioButton ellipseBtn = new JRadioButton("Ellipse");
        ellipseBtn.addActionListener(e -> {
            App.setMode(DrawAction.ELLIPSE);
            DrawPanel.clearPoints();
        });
        JRadioButton circleBtn = new JRadioButton("Circle");
        circleBtn.addActionListener(e -> {
            App.setMode(DrawAction.CIRCLE);
            DrawPanel.clearPoints();
        });
        JRadioButton rectBtn = new JRadioButton("Rectangle");
        rectBtn.addActionListener(e -> {
            App.setMode(DrawAction.RECTANGLE);
            DrawPanel.clearPoints();
        });
        JRadioButton polygonBtn = new JRadioButton("Polygon");
        polygonBtn.addActionListener(e -> {
            App.setMode(DrawAction.POLYGON);
            DrawPanel.clearPoints();
        });
        JRadioButton triangleBtn = new JRadioButton("Triangle");
        triangleBtn.addActionListener(e -> {
            App.setMode(DrawAction.TRIANGLE);
            DrawPanel.clearPoints();
        });
        JRadioButton rhombBtn = new JRadioButton("Rhombus");
        rhombBtn.addActionListener(e -> {
            App.setMode(DrawAction.RHOMBUS);
            DrawPanel.clearPoints();
        });
        JRadioButton squareBtn = new JRadioButton("Square");
        squareBtn.addActionListener(e -> {
            App.setMode(DrawAction.SQUARE);
            DrawPanel.clearPoints();
        });
        JRadioButton rhightTrBtn = new JRadioButton("Right Triangle");
        rhightTrBtn.addActionListener(e -> {
            App.setMode(DrawAction.RIGHTTRIANGLE);
            DrawPanel.clearPoints();
        });

        switchFigure.add(moveBtn);
        switchFigure.add(segmentBtn);
        switchFigure.add(rayBtn);
        switchFigure.add(lineBtn);
        switchFigure.add(polylineBtn);
        switchFigure.add(ellipseBtn);
        switchFigure.add(circleBtn);
        switchFigure.add(rectBtn);
        switchFigure.add(polygonBtn);
        switchFigure.add(triangleBtn);
        switchFigure.add(rhombBtn);
        switchFigure.add(squareBtn);
        switchFigure.add(rhightTrBtn);



        add(colorChooser);
        add(moveBtn);
        add(segmentBtn);
        add(rayBtn);
        add(lineBtn);
        add(polylineBtn);
        add(ellipseBtn);
        add(circleBtn);
        add(rectBtn);
        add(polygonBtn);
        add(triangleBtn);
        add(rhombBtn);
        add(squareBtn);
        add(rhightTrBtn);


        segmentBtn.doClick();
    }

    public static Color getCurrentColor() {
        return currentColor;
    }
}
