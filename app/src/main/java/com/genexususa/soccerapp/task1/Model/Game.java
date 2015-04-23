package com.genexususa.soccerapp.task1.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by juangarcia on 4/19/15.
 */
public class Game {

    private String id;
    private List<GameParticipant> gameParticipants;
    private Date eventDate;
    private String groupId;


    public Game(String id, List<GameParticipant> gameParticipant, Date eventDate, String group) {
        this.gameParticipants = gameParticipant;
        this.eventDate = eventDate;
        this.id = id;
        this.groupId = group;
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

    public GameParticipant getLocalParticipant()
    {
        for (int i = 0; i < gameParticipants.size(); i++) {
            if(gameParticipants.get(i).isLocal())
                return gameParticipants.get(i);
        }
        return null;
    }

    public GameParticipant getVisitorParticipant()
    {
        for (int i = 0; i < gameParticipants.size(); i++) {
            if(!gameParticipants.get(i).isLocal())
                return gameParticipants.get(i);
        }
        return null;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
