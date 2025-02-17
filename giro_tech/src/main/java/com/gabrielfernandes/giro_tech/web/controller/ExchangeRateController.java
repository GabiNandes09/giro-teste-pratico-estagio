package com.gabrielfernandes.giro_tech.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfernandes.giro_tech.service.ExchangeRateService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/exchange-rates")
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;
}
