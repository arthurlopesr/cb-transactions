package com.example.cbtransactions.presentation.controller;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.presentation.dtos.SubscriptionTypeDTO;
import com.example.cbtransactions.presentation.mapper.SubscriptionTypeMapper;
import com.example.cbtransactions.usecases.SubscriptionTypeUseCase;
import org.junit.jupiter.api.BeforeEach;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@WebMvcTest(SubscriptionTypeController.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles(profiles = "test")
class SubscriptionTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubscriptionTypeMapper mapper;

    @MockBean
    private SubscriptionTypeUseCase subscriptionTypeUseCase;

    List<SubscriptionTypeEntity> subscriptionTypeEntityList= new ArrayList<>();
    List<SubscriptionTypeDTO> subscriptionTypeDTOList = new ArrayList<>();
    SubscriptionTypeEntity firsST = new SubscriptionTypeEntity();
    SubscriptionTypeEntity secondST = new SubscriptionTypeEntity();
    SubscriptionTypeDTO firsDto = new SubscriptionTypeDTO();
    SubscriptionTypeDTO secondDto = new SubscriptionTypeDTO();

    @BeforeEach
    void setUp() {
        firsST.setSubscriptionTypeId(1L);
        firsST.setName("any_name1");
        firsST.setAccessMonths(6L);
        firsST.setPrice(BigDecimal.valueOf(300));
        firsST.setProductKey("any_product_key1");
        subscriptionTypeEntityList.add(firsST);

        firsDto.setSubscriptionTypeId(1L);
        firsDto.setName("any_name1");
        firsDto.setAccessMonths(6L);
        firsDto.setPrice(BigDecimal.valueOf(300));
        firsDto.setProductKey("any_product_key1");
        subscriptionTypeDTOList.add(firsDto);

        secondST.setSubscriptionTypeId(2L);
        secondST.setName("any_name2");
        firsST.setAccessMonths(12L);
        secondST.setPrice(BigDecimal.valueOf(600));
        secondST.setProductKey("any_product_key2");
        subscriptionTypeEntityList.add(secondST);

        secondDto.setSubscriptionTypeId(2L);
        secondDto.setName("any_name2");
        secondDto.setAccessMonths(12L);
        secondDto.setPrice(BigDecimal.valueOf(600));
        secondDto.setProductKey("any_product_key2");
        subscriptionTypeDTOList.add(secondDto);
    }

    @Test
    @DisplayName("Should call the findAll method correctly with status code 200")
    void execute_findAll_with_200_statusCode() throws Exception {
        when(subscriptionTypeUseCase.findAll()).thenReturn(subscriptionTypeEntityList);
        when(mapper.subscriptionTypeDtoList(subscriptionTypeEntityList)).thenReturn(subscriptionTypeDTOList);
        mockMvc.perform(MockMvcRequestBuilders.get("/subscription-type"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Should call the findAll method correctly with status code 204")
    void execute_findAll_with_204_statusCode() throws Exception {
        when(subscriptionTypeUseCase.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(MockMvcRequestBuilders.get("/subscription-type"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    @DisplayName("Should return exception when failed to calls the findAll method")
    void execute_findAll_with_error() throws Exception {
        when(subscriptionTypeUseCase.findAll()).thenThrow(new RuntimeException("Error test"));
        mockMvc.perform(MockMvcRequestBuilders.get("/subscription-type"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }

    @Test
    @DisplayName("Should calls the findById method with status code 200")
    void execute_findById_with_200_statusCode() throws Exception {
        when(subscriptionTypeUseCase.findById(1L)).thenReturn(Optional.ofNullable(firsST));
        when(mapper.toSubscriptionTypeDto(firsST)).thenReturn(firsDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/subscription-type/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Should calls the findById method with status code 204")
    void execute_findById_with_204_statusCode() throws Exception {
        when(subscriptionTypeUseCase.findById(1L)).thenReturn(Optional.empty());
        when(mapper.toSubscriptionTypeDto(firsST)).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/subscription-type/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    @DisplayName("Should return exception when failed to calls the findById method")
    void execute_findById_with_error() throws Exception {
        when(subscriptionTypeUseCase.findById(1L)).thenThrow(new RuntimeException("Error test"));
        mockMvc.perform(MockMvcRequestBuilders.get("/subscription-type/1"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}