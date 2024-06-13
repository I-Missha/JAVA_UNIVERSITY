package task4.view;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderWithLabel extends JPanel {

    JLabel label;
    JSlider slider;

    public SliderWithLabel(ChangeListener listener, int start, String label) {
        this.label = new JLabel(label);
        this.slider = new JSlider(JSlider.VERTICAL,1, 15, start);
        this.slider.setPaintTrack(true);
        this.slider.setPaintTicks(true);
        this.slider.setPaintLabels(true);
        this.slider.setMajorTickSpacing(1);
        this.slider.setPreferredSize(new Dimension(50, 200));
        this.slider.addChangeListener(listener);
        this.add(this.label);
        this.add(slider);
    }
}
