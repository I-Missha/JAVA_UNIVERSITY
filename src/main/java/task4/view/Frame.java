package task4.view;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BoxLayout.LINE_AXIS;

public class Frame extends JFrame{

    public Frame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);

        SliderPanelsContainer sliderPanelsContainer = new SliderPanelsContainer();

        this.add(sliderPanelsContainer, BorderLayout.SOUTH);


        this.setVisible(true);
    }
}
