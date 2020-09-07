package com.transaction.fraud.detection.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.fraud.detection.dto.TransactionDto;
import com.transaction.fraud.detection.dto.ValidationErrorDto;
import com.transaction.fraud.detection.service.FraudDetectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = {"v1/transactions"})
@Api(tags = {"transactions"})
public class FraudDetectionController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    /**
     * This method would evaluate given transaction for fraud attempt and return, if any, validation errors. It will return empty list if no
     * issues are found.
     * 
     * @param transaction
     * @return list of validation errors or empty if none
     */
    @PostMapping()
    @ResponseStatus(code = HttpStatus.OK)
    @ApiOperation(value = "Screens a transactin for fradulent attempts",
                  response = ResponseEntity.class,
                  produces = "application/json")
    public ResponseEntity<List<ValidationErrorDto>> checkForFraudAttempts(@ApiParam(value = "Transaction") @Valid @RequestBody TransactionDto transaction) {

        List<ValidationErrorDto> validationErrors = fraudDetectionService.checkForFraud(transaction);
        return CollectionUtils.isEmpty(validationErrors) ? new ResponseEntity<List<ValidationErrorDto>>(validationErrors, HttpStatus.OK)
                                                         : new ResponseEntity<List<ValidationErrorDto>>(validationErrors,
                                                                                                        HttpStatus.BAD_REQUEST);
    }

}
