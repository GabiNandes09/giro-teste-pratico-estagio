package com.gabrielfernandes.giro_tech.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

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
        if (exchangeRate == null) {
            throw new IllegalArgumentException("A Taxa de cambio não pode ser nula.");
        }
        if (exchangeRate.getDate() == null) {
            throw new IllegalArgumentException("A data não pode ser nula.");
        }
        if (exchangeRate.getCurrency_id() <= 0) {
            throw new IllegalArgumentException("A moeda deve ter id válido.");
        }

        return exchangeRateRepository.save(exchangeRate);
    }

    @Transactional(readOnly = true)
    public List<ExchangeRate> getAll() {
        return exchangeRateRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ExchangeRate> getRecent(){
        Date daysAgo = Date.from(Instant.now().minus(7, ChronoUnit.DAYS));
        return exchangeRateRepository.findLast7Days(daysAgo);
    }

    @Transactional
    public ExchangeRate update(int id, ExchangeRate exchangeRate){
        ExchangeRate response = exchangeRateRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Não encontrado")
        );
        response.setCurrency_id(exchangeRate.getCurrency_id());
        response.setDaily_rate(exchangeRate.getDaily_rate());
        response.setDaily_variation(exchangeRate.getDaily_variation());
        return exchangeRateRepository.save(response);
    }

    @Transactional
    public int deleteOld() {
        Date oldDate = Date.from(Instant.now().minus(30, ChronoUnit.DAYS));
        return exchangeRateRepository.deleteOld(oldDate);
    }
}
