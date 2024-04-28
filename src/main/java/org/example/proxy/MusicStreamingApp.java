package org.example.proxy;

public class MusicStreamingApp {
    public static void main(String[] args)
    {
        SongProxy songProxy = new SongProxy();
        /* create 5 – 10 songs */
        songProxy.addSong("Out of Bounds", "Malcolm Todd", "Demos Before Prom", 1.40);
        songProxy.addSong("Whatever She Wants", "Bryson Tiller", "Whatever She Wants", 2.39);
        songProxy.addSong("KNOT", "Token", "KNOT", 2.47);
        songProxy.addSong("Alive", "deadmau5","Kx5", 5.07 );
        songProxy.addSong("Go Off", "Doja Cat", "Scarlet", 3.17);
        songProxy.addSong("Agora Hills", "Doja Cat", "Scarlet", 4.25);

        /* search by id */
        System.out.println("\n========================================\n");
        songProxy.searchById(0);
        songProxy.searchById(5);
        songProxy.searchById(20);

        /* search by title */
        System.out.println("\n========================================\n");
        songProxy.searchByTitle("Alive");
        songProxy.searchByTitle("KNOTS");

        /* search by album */
        System.out.println("\n========================================\n");
        songProxy.searchByAlbum("Demos Before Prom");
        songProxy.searchByAlbum("Red");
        songProxy.searchByAlbum("Scarlet");
    }
}
