package com.genexususa.soccerapp.task1.Model;

import java.util.List;

/**
 * Created by juangarcia on 4/19/15.
 */
public class Team {

    private String id;
    private String name;
    private String logoFile;
    private List<GameParticipant> gamesParticipants;

    public Team(String id, String name, String logoFile, List<GameParticipant> gamesParticipants) {
        this.id = id;
        this.name = name;
        this.logoFile = logoFile;
        this.gamesParticipants = gamesParticipants;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
