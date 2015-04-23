package com.genexususa.soccerapp.task1.Networking.Responses;

import com.genexususa.soccerapp.task1.Model.GameParticipant;
import com.genexususa.soccerapp.task1.Model.Group;
import com.genexususa.soccerapp.task1.Model.Tournament;

import java.util.Date;
import java.util.List;

/**
 * Created by juangarcia on 4/23/15.
 */
public class GameResult {
    private String id;
    private Date eventDate;
    private Tournament tournament;
    private int gameNumber;
    private Group group;
    private List<GameParticipant> gameParticipants;

    public GameResult(String id, Date eventDate, Tournament tournament, Group group, List<GameParticipant> gameParticipants, int eventNumber) {
        this.id = id;
        this.eventDate = eventDate;
        this.tournament = tournament;
        this.group = group;
        this.gameParticipants = gameParticipants;
        this.gameNumber = gameNumber;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<GameParticipant> getGameParticipants() {
        return gameParticipants;
    }

    public void setGameParticipants(List<GameParticipant> gameParticipants) {
        this.gameParticipants = gameParticipants;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }
}
