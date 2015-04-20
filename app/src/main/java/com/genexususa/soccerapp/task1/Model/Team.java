package com.genexususa.soccerapp.task1.Model;

import java.util.List;

/**
 * Created by juangarcia on 4/19/15.
 */
public class Team {

    private String name;
    private String logoFile;
    private List<GameParticipant> gamesParticipants;

    public Team(String name, String logoFile, List<GameParticipant> gamesParticipants) {
        this.name = name;
        this.logoFile = logoFile;
        this.gamesParticipants = gamesParticipants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoFile() {
        return logoFile;
    }

    public void setLogoFile(String logoFile) {
        this.logoFile = logoFile;
    }

    public List<GameParticipant> getGamesParticipants() {
        return gamesParticipants;
    }

    public void setGamesParticipants(List<GameParticipant> gamesParticipants) {
        this.gamesParticipants = gamesParticipants;
    }
}
