package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.Artist;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.agoncal.quarkus.jpa.Customer;
import org.agoncal.quarkus.jpa.CustomerRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class PurchaseOrderTest {
    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    void shouldCreateAndFindById(){
        Artist artist = new Artist("Yohan Alard", "An amazing guy");
        Publisher publisher = new Publisher("YalTech Edition");
        Book book = new Book();
        book.title = "La formidable aventure de Yohan";
        book.description= "ce livre retrace la brillante carrière sur sergent Alard Yohan";
        book.nbOfPages= 222;
        book.price = new BigDecimal(156);
        book.language = Language.FRENCH;
        book.artist = artist;
        book.publisher = publisher;
        Book.persist(book);

        Customer customer = new Customer();
        customer.setEmail("yalard@gmail.com");
        customer.setLastName("Alard");
        customer.setFirstName("Yohan");
        customerRepository.persist(customer);

        OrderLine orderLine = new OrderLine();
        orderLine.item = book;
        orderLine.quantity = 2;

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.customer = customer;
        purchaseOrder.addOrderLine(orderLine);

        PurchaseOrder.persist(purchaseOrder);

    }

}