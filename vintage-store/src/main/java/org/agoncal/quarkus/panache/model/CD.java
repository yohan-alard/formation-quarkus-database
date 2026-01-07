package org.agoncal.quarkus.panache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CD extends Item {
    @Column(name = "music_company")
    String musicCompany;

    @Column(length = 100)
    String genre;

    @OneToMany(mappedBy = "cd")
    List<Track> tracks = new ArrayList<>();
}
