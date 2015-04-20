package com.genexususa.soccerapp.task1.Model;

import java.util.List;

/**
 * Created by juangarcia on 4/19/15.
 */
public class Tournament {

    private String name;
    private String hexColor;
    private List<Group> groups;

    public Tournament(String name, String hexColor, List<Group> groups) {
        this.name = name;
        this.hexColor = hexColor;
        this.groups = groups;
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
