package io.quarkus.hibernate.orm;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Random;

@ApplicationScoped
public class ArtistRepository {
    @Inject
    DataSource dataSource;

    public void persist(Artist artist) throws SQLException {
        Connection conn = dataSource.getConnection();
        artist.setId(new Random().nextLong());
        String sql = """
                Insert into t_artists(id, name, bio ,created_date)
                      values (?, ?, ?, ?)""";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setLong(1, artist.getId());
            statement.setString(2, artist.getName());
            statement.setString(3, artist.getBio());
            statement.setTimestamp(4, Timestamp.from(artist.getCreateddate()));
            statement.executeUpdate();
        }
        conn.close();
    }

    public Artist findById(Long id) throws SQLException{
        Connection conn = dataSource.getConnection();
        String sql = """
                Select id, name, bio ,created_date from t_artists
                where id = ?""";
        Artist artist = new Artist();
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                artist.setId(resultSet.getLong(1));
                artist.setName(resultSet.getString(2));
                artist.setBio(resultSet.getString(3));
                artist.setCreateddate(resultSet.getTimestamp(4).toInstant());
            } else {
                return null;
            }
        }
        conn.close();
        return  artist;
    }
}
