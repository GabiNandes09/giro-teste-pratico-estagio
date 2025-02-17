package com.gabrielfernandes.giro_tech.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielfernandes.giro_tech.entity.InvestmentHistory;
import com.gabrielfernandes.giro_tech.repository.InvestmentHistoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvestmentHistoryService {
    private final InvestmentHistoryRepository investmentHistoryRepository;

    @Transactional
    public InvestmentHistory save(InvestmentHistory investmentHistory) {
        return investmentHistoryRepository.save(investmentHistory);
    }
}
