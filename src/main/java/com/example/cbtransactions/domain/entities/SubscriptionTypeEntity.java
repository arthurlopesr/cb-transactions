package com.example.cbtransactions.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity()
@Table(name = "subscriptions_type")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeEntity implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptions_type_id")
    Long subscriptionTypeId;

    String name;

    @Column(name = "access_months")
    Long accessMonths;

    BigDecimal price;

    @Column(name = "product_key", unique = true)
    String productKey;
}
