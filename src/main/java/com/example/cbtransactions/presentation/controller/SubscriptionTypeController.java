package com.example.cbtransactions.presentation.controller;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.presentation.dtos.SubscriptionTypeDTO;
import com.example.cbtransactions.presentation.mapper.SubscriptionTypeMapper;
import com.example.cbtransactions.usecase.SubscriptionTypeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                    .orElseGet(() -> ResponseEntity.noContent().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
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
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody SubscriptionTypeDTO subscriptionTypeDTO) {
        try {
            return Optional.ofNullable(subscriptionTypeUseCase.create(subscriptionTypeDTO))
                    .map(subscriptionType -> ResponseEntity.status(HttpStatus.CREATED).<HttpStatus>build())
                    .orElseGet(() -> ResponseEntity.internalServerError().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
