package com.example.cbtransactions.presentation.mapper;

import com.example.cbtransactions.domain.entities.SubscriptionTypeEntity;
import com.example.cbtransactions.presentation.dtos.SubscriptionTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubscriptionTypeMapper {
  SubscriptionTypeMapper INSTANCE = Mappers.getMapper(SubscriptionTypeMapper.class);

  SubscriptionTypeDTO toSubscriptionTypeDto(SubscriptionTypeEntity subscriptionTypeEntity);

  List<SubscriptionTypeDTO> subscriptionTypeDtoList(List<SubscriptionTypeEntity> subscriptionTypeEntityList);
}
