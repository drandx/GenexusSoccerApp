package com.genexususa.soccerapp.task1.Model;

/**
 * Created by juangarcia on 4/19/15.
 */
public class GameParticipant {

    private String teamId;
    private int score;
    private boolean isLocal;

    public GameParticipant(int score, boolean isLocal, String teamId) {
        this.score = score;
        this.isLocal = isLocal;
        this.teamId = teamId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean isLocal) {
        this.isLocal = isLocal;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
