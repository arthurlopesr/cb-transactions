package com.example.cbtransactions.infra.repositories;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionTypeRepo extends JpaRepository<SubscriptionTypeEntity, Long> {
}
