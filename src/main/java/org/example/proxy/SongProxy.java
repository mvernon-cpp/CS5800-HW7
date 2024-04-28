package org.example.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongProxy implements SongService{
    private HashMap<Integer, Song> musicLibrary;
    private int songID;
    private String title;
    private String artist;
    private String album;
    private double duration;
    private Song song;
    public SongProxy()
    {
        this.musicLibrary = new HashMap<>();
        this.songID = 0;
    }
    public void addSong(String title, String artist, String album, double duration)
    {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.song = new Song( title, artist, album, duration);

        musicLibrary.put(songID, song);
        songID++;
    }
    @Override
    public Song searchById(Integer songID) {
        if( song == null ){
            song = new Song(title, artist, album, duration);
        }
        System.out.printf("Searching for song ID %d\n",songID);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        Song found = musicLibrary.get(songID);

        if( found != null ) {
            System.out.println("Found song(s) with ID: " + found);
            return found;
        }
        else {
            System.out.printf("No songs found with song ID [%d]\n",songID );
            return null;
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if( song == null ){
            song = new Song(this.title, artist, album, duration);
        }

        System.out.printf("Searching for song title %s\n",title);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> found = new ArrayList<>();
        for (Map.Entry<Integer, Song> set : musicLibrary.entrySet())
        {
            Song s = set.getValue();
            String songTitle = s.getTitle();
            if( songTitle.equals(title) ) {
                found.add(s);
            }
        }

        if( !found.isEmpty() )
        {
            for (Song item : found){
                System.out.println("Found song(s) with title: " + item);
            }
        }
        else {
            System.out.printf("No songs found with song title [%s]\n",title );
        }
        return found;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if( song == null ){
            song = new Song( title, artist, this.album, duration);
        }

        System.out.printf("Searching for album title %s\n",album);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> found = new ArrayList<>();
        for (Map.Entry<Integer, Song> set : musicLibrary.entrySet())
        {
            Song s = set.getValue();
            String albumTitle = s.getAlbum();
            if( albumTitle.equals(album) ) {
                found.add(s);
            }
        }

        if( !found.isEmpty() )
        {
            for (Song item : found){
                System.out.println("Found song(s) with album: " + item);
            }
        }
        else {
            System.out.printf("No songs found with album title [%s]\n",album );
        }
        return found;
    }
}
