package graphics;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    public DrawPanel(){
        setPreferredSize(new Dimension(900, 700));
        setFocusable(true);
        setBackground(Color.white);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

    }
}
