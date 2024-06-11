package com.example.cbtransactions.infra.repositories;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionTypeRepo extends JpaRepository<SubscriptionTypeEntity, Long> {
    Optional<SubscriptionTypeEntity> findByProductKey(String productKey);
}
