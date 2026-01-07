package io.quarkus.hibernate.orm;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class ArtistRepositoryTest {
    @Inject
    ArtistRepository artistRepository;

    @Test
    void shouldPersistAnArtist() throws SQLException {
        Artist artist = new Artist();
        artist.setName("Yohan");
        artist.setBio("YalTech");
        artistRepository.persist(artist);
        assertNotNull(artist.getId());

        Artist byId = artistRepository.findById(artist.getId());
        assertNotNull(byId);

    }


}