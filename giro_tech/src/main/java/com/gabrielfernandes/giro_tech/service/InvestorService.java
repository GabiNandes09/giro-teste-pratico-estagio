package com.gabrielfernandes.giro_tech.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielfernandes.giro_tech.entity.Investor;
import com.gabrielfernandes.giro_tech.repository.InvestorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvestorService {
    private final InvestorRepository investorRepository;

    @Transactional
    public Investor save(Investor investor) {
        return investorRepository.save(investor);
    }
}
