package com.gabrielfernandes.giro_tech.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfernandes.giro_tech.entity.CurrencyEntity;
import com.gabrielfernandes.giro_tech.service.CurrencyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/currencies")
public class CurrencyController {
    private final CurrencyService currencyService;

    @PostMapping
    public ResponseEntity<CurrencyEntity> create(@RequestBody CurrencyEntity currency){
        CurrencyEntity response = currencyService.save(currency);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
