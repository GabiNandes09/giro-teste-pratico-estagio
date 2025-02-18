package com.gabrielfernandes.giro_tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielfernandes.giro_tech.entity.InvestmentHistory;

public interface InvestmentHistoryRepository extends JpaRepository<InvestmentHistory, Integer> {
    @Modifying
    @Query("DELETE FROM InvestmentHistory WHERE investor_id = :investorId")
    @Transactional
    int deleteByInvestorId(@Param("investorId") Integer investorId);
}
