package com.example.cbtransactions.presentation.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeDTO {
    private Long subscriptionTypeId;

    @NotBlank(message = "Name can not be null or empty")
    @Size(min = 3, max = 30, message = "Name size should be between 5 and 30")
    private String name;

    @Max(value = 12, message = "Access months can not bigger then 12")
    private Long accessMonths;

    @NotBlank(message = "Price can not be null or empty")
    private BigDecimal price;

    @NotBlank(message = "Product key can not be null or empty")
    @Size(min = 5, max = 15, message = "Product key size should be between 15 and 15")
    private String productKey;
}
