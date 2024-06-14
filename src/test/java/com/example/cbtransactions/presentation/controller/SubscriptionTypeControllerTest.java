package com.example.cbtransactions.presentation.controller;

import com.example.cbtransactions.usecases.SubscriptionTypeUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@WebMvcTest(SubscriptionTypeController.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles(profiles = "test")
class SubscriptionTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubscriptionTypeUseCase subscriptionTypeUseCase;

    @Test
    @DisplayName("Should call the findAll endpoint correctly")
    void execute_findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/subscription-type"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}