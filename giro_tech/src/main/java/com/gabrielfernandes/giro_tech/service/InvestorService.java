package com.gabrielfernandes.giro_tech.service;

import org.springframework.stereotype.Service;

import com.gabrielfernandes.giro_tech.repository.InvestorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvestorService {
    private final InvestorRepository investorRepository;
}
