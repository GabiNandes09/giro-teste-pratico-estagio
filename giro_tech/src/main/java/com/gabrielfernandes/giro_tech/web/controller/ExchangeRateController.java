package com.gabrielfernandes.giro_tech.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public ResponseEntity<List<ExchangeRate>> getAll(){
        List<ExchangeRate> response = exchangeRateService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/recent")
    public ResponseEntity<List<ExchangeRate>> getRecent(){
        List<ExchangeRate> response = exchangeRateService.getRecent();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExchangeRate> update(@PathVariable int id, @RequestBody ExchangeRate exchangeRate){
        ExchangeRate response = exchangeRateService.update(id, exchangeRate);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/old")
    public ResponseEntity<ExchangeRate> deleteOld(){
         exchangeRateService.deleteOld();
        return ResponseEntity.ok().build();
    }
}
