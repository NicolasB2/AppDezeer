package com.example.deezerapi.model;

import java.io.Serializable;

public class TrackContainer implements Serializable {

    private Track[] data;
    private String checksum;

    public TrackContainer(Track[] data, String checksum) {
        this.data = data;
        this.checksum = checksum;
    }

    public TrackContainer() {
    }

    public Track[] getData() {
        return data;
    }

    public void setData(Track[] data) {
        this.data = data;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
