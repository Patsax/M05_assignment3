package M05_assignment3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUISlider extends JFrame{
    // some constants
    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;

    // Some elements we need for our control panel and frame in general
    private JPanel textPanel;
    private JLabel lbl; // Our text will be here
    private JSlider redSlider, greenSlider, blueSlider; // Colour Sliders
    private JSlider opacSlider; // Our Opacity Slider

    // Constructor
    public GUISlider() {
        super("Slider Window!");
        textPanel = new JPanel();
        lbl = new JLabel ("Coloured Text");
        lbl.setFont(new Font("Serif", Font.BOLD, 50)); // To make the text appear well
        textPanel.add(lbl, BorderLayout.CENTER);

        add(textPanel, BorderLayout.CENTER);
        createControls(); // Helper Constructor Method
        mixColours(); // we'll call mix method once before creating
        setSize(WIDTH, HEIGHT);
    }

    // helper method to handle the controls
    public void createControls() {
        // we need change listener to listen for sliders
        class ColourListener implements ChangeListener{

            @Override
            public void stateChanged(ChangeEvent arg0) {
                // each time we change one of the sliders, mix method will be called
                mixColours();
            }
        }

        ChangeListener listener = new ColourListener();
        // Create the sliders and assign this listener
        redSlider = new JSlider(0, 255, 0);
        redSlider.addChangeListener(listener);

        greenSlider = new JSlider(0, 255, 0);
        greenSlider.addChangeListener(listener);

        blueSlider = new JSlider(0, 255, 0);
        blueSlider.addChangeListener(listener);

        opacSlider = new JSlider(0, 255, 200);
        opacSlider.addChangeListener(listener);

        // Group them all together
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(4, 2));

        controls.add(new JLabel("Red: "));
        controls.add(redSlider);

        controls.add(new JLabel("Green: "));
        controls.add(greenSlider);

        controls.add(new JLabel("Blue: "));
        controls.add(blueSlider);

        controls.add(new JLabel("Opacity: "));
        controls.add(opacSlider);

        add(controls, BorderLayout.SOUTH); // To the bottom of the container
    }

    // now the mixer method
    public void mixColours(){
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();
        int opacity = opacSlider.getValue();

        lbl.setForeground(new Color(red, green, blue, opacity));
        // this will repaint this label every time the state of sliders change
        lbl.repaint();
    }
}

