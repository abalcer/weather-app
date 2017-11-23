package com.brainacademy.weather;

import com.brainacademy.weather.shell.MainFrame;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
