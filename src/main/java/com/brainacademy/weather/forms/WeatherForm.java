package com.brainacademy.weather.forms;

import com.brainacademy.weather.model.OpenWeatherMap;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class WeatherForm {
    public static final String BASE_WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather?appid=8d243a205cc370acdbfea2f12c757689";
    public static final String IMAGE_URL = "http://openweathermap.org/img/w/%s.png";
    private JButton closeButton;
    private JButton refreshButton;
    private JLabel cityLabel;
    private JLabel iconLabel;
    private JPanel rootPanel;
    private JLabel tempLabel;
    private JLabel cloudsLabel;
    private JLabel humidityLabel;
    private JLabel windLabel;
    private JLabel pressureLabel;

    public void refresh() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

            OpenWeatherMap openWeatherMap = mapper.readValue(new URL(BASE_WEATHER_API_URL + "&q=London"), OpenWeatherMap.class);
            cityLabel.setText(openWeatherMap.getName());

            URL iconUrl = new URL(String.format(IMAGE_URL, openWeatherMap.getWeather().get(0).getIcon()));
            iconLabel.setIcon(new ImageIcon(ImageIO.read(iconUrl)));
            tempLabel.setText(Math.round(openWeatherMap.getMain().getTemp() - 273) + "°C");
            cloudsLabel.setText(Math.round(openWeatherMap.getClouds().getAll()) + "%");
            humidityLabel.setText(Math.round(openWeatherMap.getMain().getHumidity()) + "%");
            windLabel.setText(openWeatherMap.getWind().getSpeed() + "m/s");
            pressureLabel.setText(openWeatherMap.getMain().getPressure() + "hpa");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
