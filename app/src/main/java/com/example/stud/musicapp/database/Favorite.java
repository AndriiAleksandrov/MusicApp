package com.example.stud.musicapp.database;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by W57066 on 2018-05-17.
 */

public class Favorite extends RealmObject {
    private String track ;
    private String artist ;
    private int trackid ;
    private Date date ;

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTrackid() {
        return trackid;
    }

    public void setTrackid(int trackid) {
        this.trackid = trackid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
