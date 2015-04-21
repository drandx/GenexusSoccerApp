package com.genexususa.soccerapp.task1.Networking;

import com.genexususa.soccerapp.task1.Model.Tournament;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Soham Banerjee on 13/3/15.
 */

public interface Restapi {
    //{"include": [{"groups": {"games":"gameParticipant"}}]}
    @GET("/tournaments")
    void getGamesResults(@Query("filter") String filterQuery, Callback<List<Tournament>> callback);
}
