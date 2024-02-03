package java_database.model;

import java.util.Objects;

public class SongDao {

    private int songId;
    private final String title;
    private final String artist;
    private final String genre;
    private final int releaseYear;


    public SongDao(int songId, String title, String artist, String genre, int releaseYear) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public SongDao(String title, String artist, String genre, int releaseYear) {
        this.songId = -1;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "SongDao{" +
                "songId=" + songId +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongDao songDao = (SongDao) o;
        return songId == songDao.songId && releaseYear == songDao.releaseYear && title.equals(songDao.title) && artist.equals(songDao.artist) && genre.equals(songDao.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, title, artist, genre, releaseYear);
    }
}
