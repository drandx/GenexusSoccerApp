package com.genexususa.soccerapp.task1.Model;

/**
 * Created by juangarcia on 4/19/15.
 */
public class Weather {
    private int id;
    private String main;
    private String description;

    // default constructor, getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}