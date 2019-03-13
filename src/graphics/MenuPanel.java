package graphics;

import utils.DrawAction;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private ButtonGroup switchFigure;
    private JButton borderColorChooser;
    private JButton fillColorChooser;
    private JButton clear;
    private static Color currentBorderColor;
    private static Color currentFillColor;
    private JPanel colorPanel;

    public MenuPanel() {
        setPreferredSize(new Dimension(300, 700));
        setFocusable(true);
        setLayout(new GridLayout(20, 1));
        setButtons();
        currentBorderColor = Color.BLACK;
        currentFillColor = Color.BLACK;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void setButtons() {
        colorPanel = new JPanel(new GridLayout(1, 3));
        borderColorChooser = new JButton("Border color");
        borderColorChooser.addActionListener(e -> currentBorderColor = JColorChooser.showDialog(this, "Choose color", Color.BLACK));

        fillColorChooser = new JButton("Fill color");
        fillColorChooser.addActionListener(e -> currentFillColor = JColorChooser.showDialog(this, "Choose color", Color.BLACK));

        clear = new JButton("Clear");
        clear.addActionListener(e -> App.getDrawPanel().clear());


        colorPanel.add(borderColorChooser);
        colorPanel.add(fillColorChooser);
        colorPanel.add(clear);


        switchFigure = new ButtonGroup();
        JRadioButton moveBtn = new JRadioButton("Move");
        moveBtn.addActionListener(e -> {
            App.setMode(DrawAction.MOVE);
            App.getDrawPanel().clearPoints();
        });
        JRadioButton segmentBtn = new JRadioButton("Segment");
        segmentBtn.addActionListener(e -> {
            App.setMode(DrawAction.SEGMENT);
            App.getDrawPanel().clearPoints();
        });
        JRadioButton rayBtn = new JRadioButton("Ray");
        rayBtn.addActionListener(e -> {
            App.setMode(DrawAction.RAY);
            App.getDrawPanel().clearPoints();
        });
        JRadioButton lineBtn = new JRadioButton("Line");
        lineBtn.addActionListener(e -> {
            App.setMode(DrawAction.LINE);
            App.getDrawPanel().clearPoints();
        });
        JRadioButton polylineBtn = new JRadioButton("Polyline");
        polylineBtn.addActionListener(e -> {
            App.setMode(DrawAction.POLYLINE);
            App.getDrawPanel().clearPoints();
        });
        JRadioButton ellipseBtn = new JRadioButton("Ellipse");
        ellipseBtn.addActionListener(e -> {
            App.setMode(DrawAction.ELLIPSE);
            App.getDrawPanel().clearPoints();
        });
        JRadioButton circleBtn = new JRadioButton("Circle");
        circleBtn.addActionListener(e -> {
            App.setMode(DrawAction.CIRCLE);
            App.getDrawPanel().clearPoints();
        });
        JRadioButton rectBtn = new JRadioButton("Rectangle");
        rectBtn.addActionListener(e -> {
            App.setMode(DrawAction.RECTANGLE);
            App.getDrawPanel().clearPoints();
        });
        JRadioButton polygonBtn = new JRadioButton("Polygon");
        polygonBtn.addActionListener(e -> {
            App.setMode(DrawAction.POLYGON);
            App.getDrawPanel().clearPoints();
        });
        JRadioButton rhombBtn = new JRadioButton("Rhombus");
        rhombBtn.addActionListener(e -> {
            App.setMode(DrawAction.RHOMBUS);
            App.getDrawPanel().clearPoints();
        });
        JRadioButton symBtn = new JRadioButton("Symmetric Figure");
        symBtn.addActionListener(e -> {
            App.setMode(DrawAction.SYMMETRICFIGURE);
            App.getDrawPanel().clearPoints();
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
        switchFigure.add(rhombBtn);
        switchFigure.add(symBtn);



        add(colorPanel);
        add(moveBtn);
        add(segmentBtn);
        add(rayBtn);
        add(lineBtn);
        add(polylineBtn);
        add(ellipseBtn);
        add(circleBtn);
        add(rectBtn);
        add(polygonBtn);
        add(rhombBtn);
        add(symBtn);


        segmentBtn.doClick();
    }

    public static Color getCurrentBorderColor() {
        return currentBorderColor;
    }

    public static Color getCurrentFillColor() {
        return currentFillColor;
    }
}
