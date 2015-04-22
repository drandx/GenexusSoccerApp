package com.genexususa.soccerapp.task1.Managers;

import android.util.Log;

import com.genexususa.soccerapp.task1.Model.Game;
import com.genexususa.soccerapp.task1.Model.Team;
import com.genexususa.soccerapp.task1.Model.Tournament;
import com.genexususa.soccerapp.task1.Networking.RestClient;
import com.genexususa.soccerapp.task1.Utils.TournamentObserver;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by juangarcia on 4/21/15.
 */
public class TournamentManager {

    private static volatile TournamentManager INSTANCE;

    private List<TournamentObserver> observers;

    private List<Team> teams;
    private List<Tournament> tournaments;
    private List<Game> games;

    /**
     * private constructor to prevent client from instantiating.
     *
     */
    private TournamentManager() {
        //to prevent instantiating by Reflection call
        if(INSTANCE != null)
            throw new IllegalStateException("Already initialized.");
        this.teams = new ArrayList<>();
        this.tournaments = new ArrayList<>();
        this.games = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static TournamentManager getInstance() {
        TournamentManager result = INSTANCE;
        if (result == null) {
            synchronized (TournamentManager.class) {
                result = INSTANCE;
                if (result == null) {
                    INSTANCE = result = new TournamentManager();
                }
            }
        }
        return result;
    }

    public void InitData()
    {
        Log.d("InitData", "Loading data..");
        this.LoadTeams();
        this.LoadTournaments();
        this.LoadGames();
        Log.d("InitData", "Data loaded..");
    }

    private void LoadTeams()
    {
        RestClient.get().getTeams(new Callback<List<Team>>() {
            @Override
            public void success(List<Team> teamsResponse, Response response) {
                teams = teamsResponse;
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void LoadTournaments()
    {
        RestClient.get().getGamesResults("{\"include\": \"groups\"}", new Callback<List<Tournament>>() {
            @Override
            public void success(List<Tournament> tournamentsResponse, Response response) {
               tournaments = tournamentsResponse;
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void LoadGames()
    {
        RestClient.get().getGames("{\"include\": \"gameParticipants\"}", new Callback<List<Game>>() {
            @Override
            public void success(List<Game> gamesResponse, Response response) {
                games = gamesResponse;
                notifyObservers();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public List<Game> getGames() {
        return games;
    }

    public Team getTeamById(String teamId)
    {
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i).getId().equals(teamId))
                return teams.get(i);
        }
        return null;
    }

    public void addObserver(TournamentObserver obs) {
        observers.add(obs);
    }

    private void notifyObservers() {
        for (TournamentObserver obs : observers) {
            obs.update();
        }
    }

}
