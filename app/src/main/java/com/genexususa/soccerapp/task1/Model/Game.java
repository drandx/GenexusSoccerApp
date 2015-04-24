package com.genexususa.soccerapp.task1.Model;

import java.util.Date;
import java.util.List;

public class Game {

    private String id;
    private List<GameParticipant> gameParticipants;
    private Date eventDate;
    private String groupId;
    private int gameNumber;


    public Game(String id, List<GameParticipant> gameParticipant, Date eventDate, String group, int gameNumber) {
        this.gameParticipants = gameParticipant;
        this.eventDate = eventDate;
        this.id = id;
        this.groupId = group;
        this.gameNumber = gameNumber;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }
}
