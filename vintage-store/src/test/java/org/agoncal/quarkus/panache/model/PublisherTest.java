package org.agoncal.quarkus.panache.model;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class PublisherTest {
    @Test
    @TestTransaction
    void shouldCreateAndFindById(){
        Publisher publisher = new Publisher("Yohan");
        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        publisher = Publisher.findById(publisher.id);
        assertNotNull(publisher);
    }

}