package org.example.proxy;

import java.util.List;

public interface SongService {
    void play();
    Song searchById(Integer songID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}
