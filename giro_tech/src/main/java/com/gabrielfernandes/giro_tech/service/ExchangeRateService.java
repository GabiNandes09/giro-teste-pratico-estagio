package com.gabrielfernandes.giro_tech.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielfernandes.giro_tech.entity.ExchangeRate;
import com.gabrielfernandes.giro_tech.repository.ExchangeRateRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;

    @Transactional
    public ExchangeRate save(ExchangeRate exchangeRate) {
        return exchangeRateRepository.save(exchangeRate);
    }
}
