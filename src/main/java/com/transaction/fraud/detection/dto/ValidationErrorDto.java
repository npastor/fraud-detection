package com.transaction.fraud.detection.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Validation error object.",
          description = "An object that contains detailed information about the validation failure.")
public class ValidationErrorDto {

    @ApiModelProperty(value = "The error message.")
    private String message;

    @ApiModelProperty(value = "The field.")
    private String field;

}
