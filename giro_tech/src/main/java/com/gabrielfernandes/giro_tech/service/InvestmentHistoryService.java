package com.gabrielfernandes.giro_tech.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielfernandes.giro_tech.entity.InvestmentHistory;
import com.gabrielfernandes.giro_tech.repository.CurrencyRepository;
import com.gabrielfernandes.giro_tech.repository.InvestmentHistoryRepository;
import com.gabrielfernandes.giro_tech.repository.InvestorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvestmentHistoryService {
    private final InvestmentHistoryRepository investmentHistoryRepository;
    private final InvestorRepository investorRepository;
    private final CurrencyRepository currencyRepository;

    @Transactional
    public InvestmentHistory save(InvestmentHistory investmentHistory) {
        if (investmentHistory == null) {
            throw new IllegalArgumentException("O investimento não pode ser nulo.");
        }
        if (investmentHistory.getCurrency_id() <= 0 || currencyRepository.existsById(investmentHistory.getCurrency_id())) {
            throw new IllegalArgumentException("A moeda deve ter ID válido.");
        }
        if (investmentHistory.getInvestor_id() <= 0 || !investorRepository.existsById(investmentHistory.getInvestor_id())) {
            throw new IllegalArgumentException("O investidor deve ter ID válido.");
        }

        return investmentHistoryRepository.save(investmentHistory);
    }

    @Transactional(readOnly = true)
    public List<InvestmentHistory> getAll() {
        return investmentHistoryRepository.findAll();
    }
}
