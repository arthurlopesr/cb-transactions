package com.example.cbtransactions.usecase.factory;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.presentation.dtos.SubscriptionTypeDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SubscriptionTypeFactory {

    public static SubscriptionTypeEntity fromDtoToEntity(SubscriptionTypeDTO subscriptionTypeDTO) {
        return SubscriptionTypeEntity.builder()
                .accessMonths(subscriptionTypeDTO.getAccessMonths())
                .price(subscriptionTypeDTO.getPrice())
                .name(subscriptionTypeDTO.getName())
                .productKey(subscriptionTypeDTO.getProductKey())
                .build();
    }
}
