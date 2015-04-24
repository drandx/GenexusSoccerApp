package com.genexususa.soccerapp.task1.Model;

public class GameParticipant {

    private String teamId;
    private Team team;
    private int score;
    private boolean isLocal;

    public GameParticipant(int score, boolean isLocal, String teamId, Team team) {
        this.score = score;
        this.isLocal = isLocal;
        this.teamId = teamId;
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

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
