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

        switchFigure.add(moveBtn);
        switchFigure.add(segmentBtn);
        switchFigure.add(rayBtn);
        switchFigure.add(lineBtn);
        switchFigure.add(polylineBtn);

        add(colorChooser);
        add(moveBtn);
        add(segmentBtn);
        add(rayBtn);
        add(lineBtn);
        add(polylineBtn);

        segmentBtn.doClick();
    }

    public static Color getCurrentColor() {
        return currentColor;
    }
}
