package org.example.proxy;

import java.util.List;

public class SongProxy implements SongService{
    private int songID;
    private String title;
    private String artist;
    private String album;
    private double duration;
    private Song song;
    public SongProxy(int songID, String title, String artist, String album, double duration)
    {
        this.songID = songID;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        song = new Song(songID, title, artist, album, duration);
    }
    @Override
    public void play()
    {
        if( song == null ){
            song = new Song(songID, title, artist, album, duration);
        }
        song.play();
    }
    @Override
    public Song searchById(Integer songID) {
        if( song == null ){
            song = new Song(this.songID, title, artist, album, duration);
        }
        song.searchById(songID);

        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if( song == null ){
            song = new Song(songID, this.title, artist, album, duration);
        }

        return song.searchByTitle(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if( song == null ){
            song = new Song(songID, title, artist, this.album, duration);
        }

        return song.searchByAlbum(album);
    }
}
