package com.example.cbtransactions.usecases;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;

import java.util.List;

public interface SubscriptionTypeUseCase {

    List<SubscriptionTypeEntity> findAll();
}
