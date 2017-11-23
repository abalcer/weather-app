package com.brainacademy.weather.shell;

import com.brainacademy.weather.forms.WeatherForm;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    WeatherForm weatherForm = new WeatherForm();

    public MainFrame() {
        setSize(300, 350);
        setPreferredSize(new Dimension(250, 300));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(weatherForm.getRootPanel());
        weatherForm.refresh();
        pack();
    }
}
