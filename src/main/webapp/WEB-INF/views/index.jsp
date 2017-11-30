<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4>${openWeatherMap.getName()}</h4>
<br/>
<img src="http://openweathermap.org/img/w/${openWeatherMap.getWeather().get(0).getIcon()}.png"/>
<br>
<b>${Math.round(openWeatherMap.getMain().getTemp()) - 273}°C</b>