package java_database.repository;

import java_database.Database;
import java_database.model.SongDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {

    private final Connection connection = new Database().getConnection();

    public List<SongDao> getAll() {

        String sql = "SELECT * FROM Song";
        List<SongDao> songs = new ArrayList<>();

        try {
            var preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                songs.add(getRoomFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return songs;
    }

    public SongDao getById(int id) {
        String sql = "SELECT * FROM Song where song.song_id = ?";
        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return getRoomFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void save(SongDao song) {
        String sql = "INSERT INTO Song (song_title,song_artist,song_genre,song_release_year) VALUES (?, ?, ?, ?)";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, song.getTitle());
            preparedStatement.setString(2, song.getArtist());
            preparedStatement.setString(3, song.getGenre());
            preparedStatement.setInt(4, song.getReleaseYear());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private SongDao getRoomFromResultSet(ResultSet resultSet) throws SQLException {

        int songId = resultSet.getInt("song_id");
        String songTitle = resultSet.getString("song_title");
        String songArtist = resultSet.getString("song_artist");
        String songGenre = resultSet.getString("song_genre");
        int songReleaseYear = resultSet.getInt("song_release_year");

        return new SongDao(songId, songTitle, songArtist, songGenre, songReleaseYear);
    }

}
