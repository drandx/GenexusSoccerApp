package com.genexususa.soccerapp.task1.Model;

import java.util.List;

/**
 * Created by juangarcia on 4/19/15.
 */
public class Group {

    private String name;
    private List<Game> games;

    public Group(String name, List<Game> games) {
        this.name = name;
        this.games = games;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
