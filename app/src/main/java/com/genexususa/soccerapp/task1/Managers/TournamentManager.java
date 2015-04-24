package com.genexususa.soccerapp.task1.Managers;

import com.genexususa.soccerapp.task1.Model.Game;
import com.genexususa.soccerapp.task1.Model.Team;
import com.genexususa.soccerapp.task1.Model.Tournament;
import com.genexususa.soccerapp.task1.Networking.Responses.GameResult;
import com.genexususa.soccerapp.task1.Networking.Responses.ResultsResponse;
import com.genexususa.soccerapp.task1.Networking.RestClient;
import com.genexususa.soccerapp.task1.Utils.TournamentObserver;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 *  functionality: This class manages the business logic and the data needed for the Results screen.
 *  created:       2015-04-21
 *  @author:       Juan Garcia
 *  changes:
 *  xpm:
 **/
public class TournamentManager {

    private static volatile TournamentManager INSTANCE;

    private List<TournamentObserver> observers;
    private List<Team> teams;
    private List<Tournament> tournaments;
    private List<Game> games;
    private List<GameResult> gamesResults;


    private TournamentManager() {
        if(INSTANCE != null)
            throw new IllegalStateException("Already initialized.");
        this.teams = new ArrayList<>();
        this.tournaments = new ArrayList<>();
        this.games = new ArrayList<>();
        this.gamesResults = new ArrayList<>();
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

    public List<GameResult> getGamesResults() {
        return gamesResults;
    }

    /**
     *  functionality: This method adds instances of objects observing notifications from this class.
     *  @author: Juan Garcia
     *  @param:
     *  @param:
     *  @return:
     *  @exception:
     **/    public void addObserver(TournamentObserver obs) {
        observers.add(obs);
    }

    private void notifyObservers() {
        for (TournamentObserver obs : observers) {
            obs.update();
        }
    }

    public void InitData()
    {
        this.LoadGameResults();
    }

    /**
     *  functionality: Asynchronous call to load all the teams and handles the call back internally.
     *  @author: Juan Garcia
     *  @param:
     *  @param:
     *  @return:
     *  @exception:
     **/
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

    /**
     *  functionality: Asynchronous call to load all the games results and handles the call back internally.
     *  @author: Juan Garcia
     *  @param:
     *  @param:
     *  @return:
     *  @exception:
     **/

    private void LoadGameResults()
    {
        RestClient.get().getGamesResults(new Callback<ResultsResponse>() {
            @Override
            public void success(ResultsResponse resultsResponse, Response response) {
                gamesResults = resultsResponse.getResults();
                notifyObservers();
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
