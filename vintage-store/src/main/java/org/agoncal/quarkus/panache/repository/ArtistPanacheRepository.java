package org.agoncal.quarkus.panache.repository;

import io.quarkus.hibernate.orm.Artist;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistPanacheRepository implements PanacheRepository<Artist> {
}
