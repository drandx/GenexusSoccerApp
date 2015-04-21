package com.genexususa.soccerapp.task1.Networking.Responses;

public class TournamentsResponse {
    private String id;
    private String name;
    private String hexColor;

    public TournamentsResponse() {

    }

    public TournamentsResponse(String id, String name, String hexColor) {
        this.id = id;
        this.name = name;
        this.hexColor = hexColor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }
}
