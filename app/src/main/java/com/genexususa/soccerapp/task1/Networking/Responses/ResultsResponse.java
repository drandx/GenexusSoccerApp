package com.genexususa.soccerapp.task1.Networking.Responses;

import java.util.List;

/**
 * Created by juangarcia on 4/23/15.
 */
public class ResultsResponse {
    private List<GameResult> results;

    public ResultsResponse(List<GameResult> results) {
        this.results = results;
    }

    public List<GameResult> getResults() {
        return results;
    }

    public void setResults(List<GameResult> results) {
        this.results = results;
    }
}
