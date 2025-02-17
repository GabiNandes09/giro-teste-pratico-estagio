package com.gabrielfernandes.giro_tech.repository;

import java.util.Currency;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {}
