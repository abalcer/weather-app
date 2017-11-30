package com.brainacademy.weather.controller;

import com.brainacademy.weather.model.OpenWeatherMap;
import com.brainacademy.weather.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class WelcomeController {
    private static final String BASE_WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather?appid=8d243a205cc370acdbfea2f12c757689";

    @RequestMapping("/{city}")
    public String mainPage(
            @PathVariable("city") String city, Model model) throws Exception {

        URL url = new URL(BASE_WEATHER_API_URL + "&q=" + city);
        OpenWeatherMap openWeatherMap = JsonUtils.readValue(url, OpenWeatherMap.class);

        model.addAttribute("openWeatherMap", openWeatherMap);
        return "/WEB-INF/views/index.jsp";
    }

}
