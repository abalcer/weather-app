package com.brainacademy.weather.forms;

import com.brainacademy.weather.model.OpenWeatherMap;
import com.brainacademy.weather.utils.JsonUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.URL;
import java.util.concurrent.CancellationException;

public class WeatherForm {
    private static final String BASE_WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather?appid=8d243a205cc370acdbfea2f12c757689";
    private static final String IMAGE_URL = "http://openweathermap.org/img/w/%s.png";

    private JButton refreshButton;
    private JLabel cityLabel;
    private JLabel iconLabel;
    private JPanel rootPanel;
    private JLabel tempLabel;
    private JLabel cloudsLabel;
    private JLabel humidityLabel;
    private JLabel windLabel;
    private JLabel pressureLabel;
    private JPanel infoPanel;

    public void refresh() {
        SwingWorker<OpenWeatherMap, Void> swingWorker = new WeatherSwingWorker("London");
        swingWorker.execute();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private class WeatherSwingWorker extends SwingWorker<OpenWeatherMap, Void> {
        private final String city;

        private WeatherSwingWorker(String city) {
            this.city = city;
        }


        @Override
        protected OpenWeatherMap doInBackground() throws Exception {
            URL url = new URL(BASE_WEATHER_API_URL + "&q=" + city);
            return JsonUtils.readValue(url, OpenWeatherMap.class);
        }

        @Override
        protected void done() {
            OpenWeatherMap openWeatherMap = null;
            try {
                openWeatherMap = get();
                cityLabel.setText(openWeatherMap.getName());

                URL iconUrl = new URL(String.format(IMAGE_URL, openWeatherMap.getWeather().get(0).getIcon()));
                iconLabel.setIcon(new ImageIcon(ImageIO.read(iconUrl)));
                tempLabel.setText(Math.round(openWeatherMap.getMain().getTemp() - 273) + "°C");
                cloudsLabel.setText(Math.round(openWeatherMap.getClouds().getAll()) + "%");
                humidityLabel.setText(Math.round(openWeatherMap.getMain().getHumidity()) + "%");
                windLabel.setText(openWeatherMap.getWind().getSpeed() + "m/s");
                pressureLabel.setText(openWeatherMap.getMain().getPressure() + "hpa");
            } catch (CancellationException e) {
                e.printStackTrace();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPanel,
                        "Unable to get result",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
