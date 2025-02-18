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
        if (currency == null) {
            throw new IllegalArgumentException("A moeda não pode ser nula.");
        }
        if (currency.getName() == null || currency.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da moeda é obrigatório.");
        }
        if (currency.getType() == null || currency.getType().trim().isEmpty()) {
            throw new IllegalArgumentException("O tipo da moeda é obrigatório.");
        }

        if (currencyRepository.existsByName(currency.getName())) {
            throw new IllegalArgumentException("Já existe uma moeda com este nome.");
        }
        
        return currencyRepository.save(currency);
    }

    @Transactional(readOnly = true)
    public List<CurrencyEntity> getAll() {
        return currencyRepository.findAll();
    }

    
}
