package com.example.cbtransactions.usecases.impl;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.infra.repositories.SubscriptionTypeRepo;
import com.example.cbtransactions.usecases.SubscriptionTypeUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionTypeUseCaseImpl implements SubscriptionTypeUseCase {

    private final SubscriptionTypeRepo subscriptionTypeRepo;

    public SubscriptionTypeUseCaseImpl(SubscriptionTypeRepo subscriptionTypeRepo) {
        this.subscriptionTypeRepo = subscriptionTypeRepo;
    }

    @Override
    public List<SubscriptionTypeEntity> findAll() {
        return subscriptionTypeRepo.findAll();
    }
}
