package com.gabrielfernandes.giro_tech.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielfernandes.giro_tech.entity.CurrencyEntity;
import com.gabrielfernandes.giro_tech.repository.CurrencyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Transactional
    public CurrencyEntity save(CurrencyEntity currency) {
        return currencyRepository.save(currency);
    }

    @Transactional(readOnly = true)
    public List<CurrencyEntity> getAll() {
        return currencyRepository.findAll();
    }

    
}
