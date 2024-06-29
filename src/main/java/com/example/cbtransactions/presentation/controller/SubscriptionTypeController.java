package com.example.cbtransactions.presentation.controller;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.presentation.mapper.SubscriptionTypeMapper;
import com.example.cbtransactions.presentation.dtos.SubscriptionTypeDTO;
import com.example.cbtransactions.usecases.SubscriptionTypeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/subscription-type"))
public class SubscriptionTypeController {

    private final SubscriptionTypeUseCase subscriptionTypeUseCase;

    private final SubscriptionTypeMapper mapper;

    @GetMapping
    public ResponseEntity<List<SubscriptionTypeDTO>> findAll() {
        List<SubscriptionTypeEntity> subscriptionTypeEntityList = subscriptionTypeUseCase.findAll();
        List<SubscriptionTypeDTO> subscriptionTypeResponse = mapper.toSubscriptionTypeEntityToDtoList(subscriptionTypeEntityList);
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeResponse);
    }
}
