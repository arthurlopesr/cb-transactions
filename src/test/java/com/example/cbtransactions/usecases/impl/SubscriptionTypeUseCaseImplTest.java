package com.example.cbtransactions.usecases.impl;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.infra.repositories.SubscriptionTypeRepo;
import com.example.cbtransactions.presentation.dtos.SubscriptionTypeDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@WebMvcTest(SubscriptionTypeUseCaseImpl.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SubscriptionTypeUseCaseImplTest {

    @Mock
    private SubscriptionTypeRepo subscriptionTypeRepo;

    @InjectMocks
    private SubscriptionTypeUseCaseImpl subscriptionTypeUseCase;

    @Test
    @DisplayName("Should return all subscription type created when calls findAll method")
    void execute_findAll() {
        List<SubscriptionTypeEntity> subscriptionTypeEntityList = new ArrayList<>();

        SubscriptionTypeEntity firsST = new SubscriptionTypeEntity();
        firsST.setSubscriptionTypeId(1L);
        firsST.setName("any_name1");
        firsST.setAccessMonths(6L);
        firsST.setPrice(BigDecimal.valueOf(300));
        firsST.setProductKey("any_product_key1");
        subscriptionTypeEntityList.add(firsST);

        SubscriptionTypeEntity secondST = new SubscriptionTypeEntity();
        secondST.setSubscriptionTypeId(2L);
        secondST.setName("any_name2");
        firsST.setAccessMonths(12L);
        secondST.setPrice(BigDecimal.valueOf(600));
        secondST.setProductKey("any_product_key2");
        subscriptionTypeEntityList.add(secondST);

        when(subscriptionTypeUseCase.findAll()).thenReturn(subscriptionTypeEntityList);
        List<SubscriptionTypeEntity> results = subscriptionTypeUseCase.findAll();
        assertEquals(subscriptionTypeEntityList.size(), results.size());
        assertTrue(results.containsAll(subscriptionTypeEntityList));
    }
}