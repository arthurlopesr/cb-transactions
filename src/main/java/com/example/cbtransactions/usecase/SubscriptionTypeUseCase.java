package com.example.cbtransactions.usecase;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.presentation.dtos.SubscriptionTypeDTO;

import java.util.List;
import java.util.Optional;

public interface SubscriptionTypeUseCase {
    List<SubscriptionTypeEntity> findAll();
    Optional<SubscriptionTypeEntity> findById(Long subscriptionTypeId);
    SubscriptionTypeEntity create(SubscriptionTypeDTO subscriptionTypeDTO);
}
