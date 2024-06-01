package task4.view;

import task4.factory.Factory;
import task4.factory.Settings;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {
    public Frame(Factory factory, Settings settings) {
        FactoryPanel factoryPanel = new FactoryPanel(factory);
        this.setSize(new Dimension(1080, 720));
        this.setTitle("factory");
        this.getContentPane().add(factoryPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
