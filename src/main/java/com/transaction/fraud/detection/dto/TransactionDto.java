package com.transaction.fraud.detection.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * For this assignment, I have added only few fields to keep it short. But in real system, this would be a representation of actual
 * transaction.
 */
@Data
@Builder
public class TransactionDto {

    @NotNull
    @ApiModelProperty(value = "Customer id.")
    private Long customerId;

    @NotNull
    @ApiModelProperty(value = "Transaction amount.")
    private Double amount;

    @NotBlank
    @ApiModelProperty(value = "Billing Name on this transaction.")
    private String billingName;

}
