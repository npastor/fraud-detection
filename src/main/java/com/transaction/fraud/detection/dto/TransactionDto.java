package com.transaction.fraud.detection.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

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
