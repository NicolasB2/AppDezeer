package com.example.deezerapi.model;

import java.io.Serializable;

public class User implements Serializable  {

    private long id;
    private String name;
    private String tracklist;
    private String type;

    public User(long id, String name, String tracklist, String type) {
        this.id = id;
        this.name = name;
        this.tracklist = tracklist;
        this.type = type;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
