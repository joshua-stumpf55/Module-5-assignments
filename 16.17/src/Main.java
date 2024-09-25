import javax.swing.*;
import java.awt.*;
import java.awt.event.ChangeEvent;
import java.awt.event.ChangeListener;

public class Main extends JFrame {

    private JTextArea textArea;
    private JSlider redSlider, greenSlider, blueSlider, opacitySlider;

    public Main() {
        setTitle("Text Color Selector");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //display colored text
        textArea = new JTextArea("Sample Text");
        textArea.setFont(new Font("Arial", Font.BOLD, 24));
        textArea.setEditable(false);
        textArea.setOpaque(false); // Makes the text area transparent
        add(textArea, BorderLayout.CENTER);

        // Panel for sliders
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(4, 2));

        // Red Slider
        redSlider = createSlider("Red");
        sliderPanel.add(new JLabel("Red:"));
        sliderPanel.add(redSlider);

        // Green Slider
        greenSlider = createSlider("Green");
        sliderPanel.add(new JLabel("Green:"));
        sliderPanel.add(greenSlider);

        // Blue Slider
        blueSlider = createSlider("Blue");
        sliderPanel.add(new JLabel("Blue:"));
        sliderPanel.add(blueSlider);

        // Opacity Slider
        opacitySlider = createSlider("Opacity");
        sliderPanel.add(new JLabel("Opacity:"));
        sliderPanel.add(opacitySlider);

        add(sliderPanel, BorderLayout.SOUTH);


        updateTextColor();

        setVisible(true);
    }

    private JSlider createSlider(String name) {
        JSlider slider = new JSlider(0, 255);
        slider.setValue(0);
        slider.setMajorTickSpacing(51);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateTextColor();
            }
        });
        return slider;
    }

    private void updateTextColor() {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();
        int opacity = opacitySlider.getValue();

        Color textColor = new Color(red, green, blue, opacity);
        textArea.setForeground(textColor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorSelector::new);
    }
}
