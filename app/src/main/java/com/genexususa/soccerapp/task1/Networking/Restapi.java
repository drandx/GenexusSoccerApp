package com.genexususa.soccerapp.task1.Networking;

import com.genexususa.soccerapp.task1.Model.Game;
import com.genexususa.soccerapp.task1.Model.Team;
import com.genexususa.soccerapp.task1.Model.Tournament;
import com.genexususa.soccerapp.task1.Networking.Responses.ResultsResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 *  functionality: This class contains the representation of some of the REST services available.
 *  created:       2015-04-23
 *  @author:       Juan Garcia
 *  changes:
 *  xpm:
 **/
public interface Restapi {
    @GET("/tournaments")
    void getGamesResults(@Query("filter") String filterQuery, Callback<List<Tournament>> callback);
    @GET("/teams")
    void getTeams(Callback<List<Team>> callback);
    @GET("/games")
    void getGames(@Query("filter") String filterQuery, Callback<List<Game>> callback);
    @GET("/games/gameResults")
    void getGamesResults(Callback<ResultsResponse> callback);
}
