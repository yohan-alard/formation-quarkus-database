package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.agoncal.quarkus.jpa.Customer;
import org.agoncal.quarkus.jpa.CustomerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class CustomerRepositoryTest {
    @Inject
    CustomerPanacheRepository customerRepository;

    @Test
    @TestTransaction
    void shouldCreateAndFindById(){
        Customer customer = new Customer("Yohan", "Alard");
        customerRepository.persist(customer);
        assertNotNull(customer.getId());

        customer = customerRepository.findById(customer.getId());
        assertNotNull(customer);
    }
  
}