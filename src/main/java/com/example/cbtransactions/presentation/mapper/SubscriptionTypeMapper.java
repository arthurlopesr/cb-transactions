package com.example.cbtransactions.presentation.mapper;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.presentation.dtos.SubscriptionTypeDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubscriptionTypeMapper {
    private final ModelMapper mapper;

    public SubscriptionTypeDTO toSubscriptionTypeEntityToDto(SubscriptionTypeEntity subscriptionType) {
        return mapper.map(subscriptionType, SubscriptionTypeDTO.class);
    }

    public List<SubscriptionTypeDTO> toSubscriptionTypeEntityToDtoList(List<SubscriptionTypeEntity> subscriptionTypeList) {
        return subscriptionTypeList.stream()
                .map(this::toSubscriptionTypeEntityToDto).toList();
    }
}
