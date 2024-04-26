package org.example.proxy;

import java.util.ArrayList;
import java.util.List;

public class Song implements SongService{
    private String title;
    private int songID;
    private String artist;
    private String album;
    private double duration;
    public Song(int songID, String title, String artist, String album, double duration)
    {
        this.songID = songID;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    @Override
    public String toString()
    {
        return String.format("[%s by %s from %s for %.2f minutes]",title, artist, album, duration);
    }

    @Override
    public void play() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        System.out.println("Now playing: " + this);
    }

    @Override
    public Song searchById(Integer songID) {
        System.out.printf("Searching for song ID %d\n",songID);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        if( this.songID == songID ) {
            System.out.println("Found song(s) with ID: " + this);
            return this;
        }
        else {
            System.out.printf("No songs found with song ID [%d]\n",songID );
            return null;
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        System.out.printf("Searching for song title %s\n",title);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> found = new ArrayList<>();
        if( this.title.equals(title) ) {
            found.add(this);
            System.out.println("Found song(s) with title: " + this);

            return found;
        }
        else {
            System.out.printf("No songs found with song title [%s]\n",title );
            return null;
        }
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        System.out.printf("Searching for album title %s\n",album);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> found = new ArrayList<>();
        if( this.album.equals(album) ) {
            found.add(this);
            System.out.println("Found song(s) with album: " + this);

            return found;
        }
        else {
            System.out.printf("No songs found with song album [%s]\n",album );
            return null;
        }
    }
}
