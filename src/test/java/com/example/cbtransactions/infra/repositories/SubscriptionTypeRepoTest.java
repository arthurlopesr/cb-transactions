package com.example.cbtransactions.infra.repositories;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@WebMvcTest(SubscriptionTypeRepo.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SubscriptionTypeRepoTest {

    @Autowired
    private SubscriptionTypeRepo subscriptionTypeRepo;

    @BeforeAll
    public void loadSubscriptionsType() {
        List<SubscriptionTypeEntity> listSubscriptionType = new ArrayList<>();
        SubscriptionTypeEntity firsSubscriptionType = new SubscriptionTypeEntity(1L, "any_name", 3L, BigDecimal.valueOf(300), "any_product_key1");
        listSubscriptionType.add(firsSubscriptionType);
        SubscriptionTypeEntity secondSubscriptionType = new SubscriptionTypeEntity(2L, "any_name", 6L, BigDecimal.valueOf(1000), "any_product_key2");
        listSubscriptionType.add(secondSubscriptionType);

        subscriptionTypeRepo.saveAll(listSubscriptionType);
    }

    @AfterAll
    public void dropDatabase() {
        subscriptionTypeRepo.deleteAll();
    }
}