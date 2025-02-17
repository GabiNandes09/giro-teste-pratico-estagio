package com.gabrielfernandes.giro_tech.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfernandes.giro_tech.entity.ExchangeRate;
import com.gabrielfernandes.giro_tech.service.ExchangeRateService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/exchange-rates")
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @PostMapping
    public ResponseEntity<ExchangeRate> create (@RequestBody ExchangeRate exchangeRate){
        ExchangeRate exchangeRateResponse = exchangeRateService.save(exchangeRate);
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeRateResponse);
    }
}
