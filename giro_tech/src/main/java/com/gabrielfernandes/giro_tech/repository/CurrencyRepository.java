package com.gabrielfernandes.giro_tech.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielfernandes.giro_tech.entity.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {

    boolean existsByName(String name);}
