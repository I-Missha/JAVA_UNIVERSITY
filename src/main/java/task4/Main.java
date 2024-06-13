package task4;

import task4.factory.ConfigReader.ConfigReader;
import task4.factory.Factory;
import task4.factory.Settings;
import task4.view.Frame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] argc) {
        ConfigReader configReader = new ConfigReader();
        Settings settings = new Settings(5000, 3000, 3000, 15000);
        Factory factory = new Factory(configReader, settings);
        SwingUtilities.invokeLater(() -> {Frame frame = new Frame(factory, settings);});
        factory.run();
    }
}
