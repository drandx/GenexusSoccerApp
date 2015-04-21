package com.genexususa.soccerapp.task1.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by juangarcia on 4/19/15.
 */
public class Game {

    private String id;
    private List<GameParticipant> gameParticipant;
    private Date eventDate;

    public Game(String id, List<GameParticipant> gameParticipant, Date eventDate) {
        this.gameParticipant = gameParticipant;
        this.eventDate = eventDate;
        this.id = id;
    }


    public List<GameParticipant> getGameParticipant() {
        return gameParticipant;
    }

    public void setGameParticipant(List<GameParticipant> gameParticipant) {
        this.gameParticipant = gameParticipant;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
