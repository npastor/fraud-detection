package com.transaction.fraud.detection.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
@ApiModel(value = "Generic validation result object.",
          description = "An object that contains detailed information about the validation failure.")
public class ValidationErrorDto {

    @ApiModelProperty(value = "The error message.")
    private String message;

    @ApiModelProperty(value = "The field.")
    private String field;

}
