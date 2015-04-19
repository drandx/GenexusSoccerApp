package com.genexususa.soccerapp.task1.Networking;

import com.genexususa.soccerapp.task1.Networking.Responses.WeatherResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Soham Banerjee on 13/3/15.
 */

public interface Restapi {

    @GET("/weather")
    void getWeather(@Query("q") String cityName, Callback<WeatherResponse> callback);
}
