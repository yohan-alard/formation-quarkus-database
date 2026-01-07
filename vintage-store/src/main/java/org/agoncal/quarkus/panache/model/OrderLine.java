package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "t_purchase_order_line")
public class OrderLine extends PanacheEntity {
    @Column(nullable = false)
    public Integer quantity;

    @ManyToOne
    @JoinColumn(name="item_fk")
    Item item;

    @ManyToOne
    @JoinColumn(name = "purchase_order_fk")
    PurchaseOrder purchaseOrder;

    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();
}
