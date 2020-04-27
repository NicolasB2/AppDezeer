package com.example.deezerapi.model;

import java.io.Serializable;

public class Album implements Serializable {

    private Long id;
    private String title;
    private String cover;
    private String cover_big;
    private String release_date;

    public Album(Long id, String title, String cover, String cover_big, String release_date) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.cover_big = cover_big;
        this.release_date = release_date;
    }

    public Album() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover_big() {
        return cover_big;
    }

    public void setCover_big(String cover_big) {
        this.cover_big = cover_big;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
