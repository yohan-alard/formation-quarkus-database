package org.agoncal.quarkus.panache.model;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDate;

@Enabled
@Entity
public class Book extends Item {
    @Column(length = 15)
    public String isbn;

    @Column(name = "nb_of_pages")
    public Integer nbOfPages;

    @Column(name = "publication_date")
    public LocalDate publicationDate;

    @Enumerated(EnumType.STRING)
    public Language language;

    @ManyToOne
    @JoinColumn(name = "publisher_fk")
    public Publisher publisher;
}
