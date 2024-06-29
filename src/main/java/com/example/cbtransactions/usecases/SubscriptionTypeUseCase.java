package com.example.cbtransactions.usecases;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;

import java.util.List;
import java.util.Optional;

public interface SubscriptionTypeUseCase {
    List<SubscriptionTypeEntity> findAll();

    Optional<SubscriptionTypeEntity> findById(Long subscriptionTypeId);
}
