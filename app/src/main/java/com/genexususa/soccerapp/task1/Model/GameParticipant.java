package com.genexususa.soccerapp.task1.Model;

/**
 * Created by juangarcia on 4/19/15.
 */
public class GameParticipant {

    private Team team;
    private int score;
    private boolean isLocal;

    public GameParticipant(Team team, int score, boolean isLocal) {
        this.team = team;
        this.score = score;
        this.isLocal = isLocal;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
}
