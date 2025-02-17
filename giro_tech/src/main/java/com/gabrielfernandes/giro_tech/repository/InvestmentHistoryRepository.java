package com.gabrielfernandes.giro_tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielfernandes.giro_tech.entity.InvestmentHistory;

public interface InvestmentHistoryRepository extends JpaRepository<InvestmentHistory, Integer> {

}
