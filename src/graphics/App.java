package graphics;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private JPanel drawPanel;
    private JPanel menuPanel;
    public App() {
        super("IT Squad");
        setSize(1400, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 50, 1200, 700);
        setVisible(true);
        Container container = new Container();
        container.setLayout(new BorderLayout());
        drawPanel = new DrawPanel();
        menuPanel = new MenuPanel();
        container.add(drawPanel, BorderLayout.CENTER);
        container.add(menuPanel, BorderLayout.WEST);
        setContentPane(container);
    }
}
