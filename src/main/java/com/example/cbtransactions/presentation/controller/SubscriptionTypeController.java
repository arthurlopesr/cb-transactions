package com.example.cbtransactions.presentation.controller;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.presentation.dtos.SubscriptionTypeDTO;
import com.example.cbtransactions.presentation.mapper.SubscriptionTypeMapper;
import com.example.cbtransactions.usecases.SubscriptionTypeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/subscription-type"))
public class SubscriptionTypeController {

    private final SubscriptionTypeUseCase subscriptionTypeUseCase;

    private static final SubscriptionTypeMapper mapper = SubscriptionTypeMapper.INSTANCE;

    @GetMapping
    public ResponseEntity<List<SubscriptionTypeDTO>> findAll() {
        try {
            List<SubscriptionTypeEntity> subscriptionTypeList = subscriptionTypeUseCase.findAll();
            List<SubscriptionTypeDTO> subscriptionTypeListResponse = mapper.subscriptionTypeDtoList(subscriptionTypeList);

            return Optional.ofNullable(subscriptionTypeListResponse)
                    .filter(list -> !list.isEmpty())
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{subscriptionTypeId}")
    public ResponseEntity<SubscriptionTypeDTO> findById(@PathVariable("subscriptionTypeId") Long subscriptionTypeId) {
        try {
            Optional<SubscriptionTypeEntity> subscriptionType = subscriptionTypeUseCase.findById(subscriptionTypeId);

            return subscriptionType
                    .map(type -> {
                        SubscriptionTypeDTO subscriptionTypeResponse = mapper.toSubscriptionTypeDto(type);
                        return ResponseEntity.ok(subscriptionTypeResponse);
                    })
                    .orElseGet(() -> ResponseEntity.noContent().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
