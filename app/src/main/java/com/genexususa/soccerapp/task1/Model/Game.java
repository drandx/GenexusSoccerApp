package com.genexususa.soccerapp.task1.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by juangarcia on 4/19/15.
 */
public class Game {

    private List<GameParticipant> gameParticipants;
    private Date eventDate;

    public Game(List<GameParticipant> gameParticipants, Date eventDate) {
        this.gameParticipants = gameParticipants;
        this.eventDate = eventDate;
    }

    public List<GameParticipant> getGameParticipants() {
        return gameParticipants;
    }

    public void setGameParticipants(List<GameParticipant> gameParticipants) {
        this.gameParticipants = gameParticipants;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
