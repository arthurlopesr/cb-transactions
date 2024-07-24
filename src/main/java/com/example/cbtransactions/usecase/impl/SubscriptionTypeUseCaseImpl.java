package com.example.cbtransactions.usecase.impl;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.infra.repositories.SubscriptionTypeRepo;
import com.example.cbtransactions.presentation.dtos.SubscriptionTypeDTO;
import com.example.cbtransactions.usecase.SubscriptionTypeUseCase;
import com.example.cbtransactions.usecase.factory.SubscriptionTypeFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<SubscriptionTypeEntity> findById(Long subscriptionTypeId) {
        return subscriptionTypeRepo.findById(subscriptionTypeId);
    }

    @Override
    public SubscriptionTypeEntity create(SubscriptionTypeDTO subscriptionTypeDTO) {
        return subscriptionTypeRepo.save(SubscriptionTypeFactory.fromDtoToEntity(subscriptionTypeDTO));
    }
}
