package task4.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import static javax.swing.BoxLayout.*;


public class SliderPanelsContainer extends JPanel {
    public SliderPanelsContainer() {

//        JPanel panel = new JPanel();
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new GridBagLayout());
        JLabel label1 = new JLabel("Slider 1:");
        label1.setPreferredSize(new Dimension(150, 25));
//        JSlider slider1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        JSlider slider1 = createSlider();
        slider1.setMajorTickSpacing(20);
        slider1.setMinorTickSpacing(5);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        this.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL, new Insets(1 ,5 , 1,5), 0, 0));
        this.add(slider1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL, new Insets(4 ,4 , 4,4), 0, 0));

        JLabel label2 = new JLabel("Slider 2:");
////        JSlider slider2 = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
        JSlider slider2 = createSlider();
        slider2.setMajorTickSpacing(20);
        slider2.setMinorTickSpacing(10);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        this.add(label2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL, new Insets(1 ,5 , 1,5), 0, 0));
        this.add(slider2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL, new Insets(4 ,4 , 4,4), 0, 0));
    }

    private JSlider createSlider() {
        JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 10);
        slider.setPreferredSize(new Dimension(150, 50));
//        slider.setPreferredSize(new Dimension(50, 50));
//        slider.setPaintLabels(true);
        return slider;
    }
}
