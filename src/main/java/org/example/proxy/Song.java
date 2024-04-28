package org.example.proxy;

import java.util.ArrayList;
import java.util.List;

public class Song{
    private String title;
    private String artist;
    private String album;
    private double duration;
    public Song( String title, String artist, String album, double duration)
    {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public double getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this. title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
    @Override
    public String toString()
    {
        return String.format("[%s by %s from %s for %.2f minutes]",title, artist, album, duration);
    }
}
