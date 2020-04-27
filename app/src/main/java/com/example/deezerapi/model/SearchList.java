package com.example.deezerapi.model;

public class SearchList {

    private PlayList[] data;
    private long total;
    private String next;


    public SearchList(PlayList[] data, long total, String next) {
        this.data = data;
        this.total = total;
        this.next = next;
    }

    public SearchList() {
    }

    public PlayList[] getData() {
        return data;
    }

    public void setData(PlayList[] data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
