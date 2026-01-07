package org.agoncal.quarkus.panache.repository;

import io.quarkus.hibernate.orm.Artist;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class ArtistPanacheRepositoryTest {
    @Inject
    ArtistPanacheRepository artistPanacheRepository;

    @Test
    @TestTransaction
    void shouldPersistAnArtist() throws SQLException {
        Artist artist = new Artist();
        artist.setName("Yohan");
        artist.setBio("YalTech");
        artistPanacheRepository.persist(artist);
        assertNotNull(artist.getId());

        Artist byId = artistPanacheRepository.findById(artist.getId());
        assertNotNull(byId);

    }


}