
package com.brainacademy.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OpenWeatherMap {

    @JsonProperty("coord")
    private Coord coord;

    @JsonProperty("weather")
    private List<Weather> weather = null;

    @JsonProperty("base")
    private String base = "cmc stations";

    @JsonProperty("main")
    private WeatherMain main;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("clouds")
    private Clouds clouds;

    @JsonProperty("dt")
    private Integer dt;

    @JsonProperty("sys")
    private Sys sys;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cod")
    private Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
}
