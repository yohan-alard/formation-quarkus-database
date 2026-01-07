package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.Artist;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name= "t_items")
public class Item extends PanacheEntity {
    @Column(length = 100, nullable = false)
    String title;
    @Column(length = 3000, nullable = false)
    String description;
    @Column(nullable = false)
    BigDecimal price;
    @Column(name="created_date", nullable = false)
    Instant createDate = Instant.now();

    @JoinColumn(name = "artist_fk")
    @ManyToOne
    public Artist artist;
}
