package org.example.proxy;

public class MusicStreamingApp {
    public static void main(String[] args)
    {
        /* create 5 – 10 songs */
        SongService song1 = new SongProxy(100, "Out of Bounds", "Malcolm Todd", "Demos Before Prom", 1.40);
        SongService song2 = new SongProxy(101, "Whatever She Wants", "Bryson Tiller", "Whatever She Wants", 2.39);
        SongService song3 = new SongProxy(103, "KNOT", "Token", "KNOT", 2.47);
        SongService song4 = new SongProxy(104, "Alive", "deadmau5","Kx5", 5.07 );
        SongService song5 = new SongProxy(105, "Go Off", "Doja Cat", "Scarlet", 3.17);
        SongService song6 = new SongProxy(106, "Agora Hills", "Doja Cat", "Scarlet", 4.25);

        song1.play();
        song2.play();
        song3.play();
        song4.play();
        song5.play();
        song6.play();

        /* search by id */
        System.out.println("\n========================================\n");
        song2.searchById(101);

        /* search by title */
        System.out.println("\n========================================\n");
        song4.searchByTitle("Alive");

        /* search by album */
        System.out.println("\n========================================\n");
        song1.searchByAlbum("Demos Before Prom");
    }
}
