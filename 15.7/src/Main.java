//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Color Changer");
        CircleColorChanger panel = new CircleColorChanger();
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Center the window
    }
}

class CircleColorChanger extends JPanel {

    private Color circleColor = Color.WHITE;

    public CircleColorChanger() {
        // Add mouse listener to change color on press
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                circleColor = Color.BLACK; // Change color to black
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                circleColor = Color.WHITE; // Change color to white on mouse release
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(circleColor);
        int diameter = 100;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        g.fillOval(x, y, diameter, diameter);
    }
}
