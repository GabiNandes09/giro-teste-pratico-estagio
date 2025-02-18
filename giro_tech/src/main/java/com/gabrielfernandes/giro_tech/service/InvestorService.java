package com.gabrielfernandes.giro_tech.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielfernandes.giro_tech.entity.Investor;
import com.gabrielfernandes.giro_tech.repository.InvestmentHistoryRepository;
import com.gabrielfernandes.giro_tech.repository.InvestorRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvestorService {
    private final InvestorRepository investorRepository;
    private final InvestmentHistoryRepository investmentHistoryRepository;

    @Transactional
    public Investor save(Investor investor) {
        return investorRepository.save(investor);
    }

    @Transactional(readOnly = true)
    public List<Investor> getAll() {
        return investorRepository.findAll();
    }

    @Transactional
    public void delete(int id) {
        if (!investorRepository.existsById(id)) {
            throw new EntityNotFoundException("Investidor não encontrado!");
        }
        investmentHistoryRepository.deleteByInvestorId(id);
        investorRepository.deleteById(id);
    }
}
