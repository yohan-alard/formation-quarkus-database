package io.quarkus.hibernate.orm;

import java.time.Instant;

public class Artist {
    private Long id;
    private String name;
    private String bio;
    private Instant createddate = Instant.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Instant getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Instant createddate) {
        this.createddate = createddate;
    }

    @Override
    public String toString() {
        return "io.quarkus.hibernate.orm.Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", createddate=" + createddate +
                '}';
    }
}
