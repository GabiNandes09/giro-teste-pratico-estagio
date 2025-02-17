package com.gabrielfernandes.giro_tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielfernandes.giro_tech.entity.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {

}
