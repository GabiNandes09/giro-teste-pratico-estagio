package com.gabrielfernandes.giro_tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielfernandes.giro_tech.entity.Investor;

public interface InvestorRepository extends JpaRepository<Investor, Integer> {

}
