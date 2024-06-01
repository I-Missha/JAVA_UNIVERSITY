package task4.view.listeners;

import task4.factory.model.Observable;
import task4.view.events.AccessoriesSupplierEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AccessoriesSliderListener extends Observable implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        notify(new AccessoriesSupplierEvent(slider.getValue()));
    }
}
