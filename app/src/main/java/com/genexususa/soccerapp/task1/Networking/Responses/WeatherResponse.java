package com.genexususa.soccerapp.task1.Networking.Responses;

import com.genexususa.soccerapp.task1.Model.Weather;

/**
 * Created by juangarcia on 4/19/15.
 */
public class WeatherResponse {
    private int cod;
    private String base;
    private Weather main;

    // default constructor, getters and setters


    public WeatherResponse() {

    }

    public WeatherResponse(int cod, String base, Weather main) {
        this.cod = cod;
        this.base = base;
        this.main = main;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Weather getWeather() {
        return main;
    }

    public void setWeather(Weather main) {
        this.main = main;
    }
}
