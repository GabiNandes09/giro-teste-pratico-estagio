package com.gabrielfernandes.giro_tech.service;

import org.springframework.stereotype.Service;

import com.gabrielfernandes.giro_tech.repository.CurrencyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    
}
