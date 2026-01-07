package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;


@Table(name="t_publisher")
@Entity
public class Publisher extends PanacheEntity {
    @Column(nullable = false, length = 50)
    String name;

    @Column(name = "creation_date", nullable = false, length = 50 )
    Instant createdDate = Instant.now();

    public Publisher(){
    }
    public Publisher(String name) {
        this.name = name;
    }
}
