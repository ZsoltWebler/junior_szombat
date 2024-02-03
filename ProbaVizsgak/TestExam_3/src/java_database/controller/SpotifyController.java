package java_database.controller;

import java_database.repository.SongRepository;
import java_database.view.Spotify;

public class SpotifyController {


    public SpotifyController() {
        SongRepository songRepository = new SongRepository();

        Spotify spotify = new Spotify(songRepository);
        spotify.setVisible(true);
    }


}
