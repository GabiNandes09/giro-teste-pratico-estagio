package com.gabrielfernandes.giro_tech.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gabrielfernandes.giro_tech.entity.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
    @Query("SELECT e FROM ExchangeRate e WHERE e.date >= :startDate")
    List<ExchangeRate> findLast7Days(@Param("startDate") LocalDate startDate);
}
