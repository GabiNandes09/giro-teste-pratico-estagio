package com.gabrielfernandes.giro_tech.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "investiment_historys")
public class InvestmentHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "initial_amount", nullable = false)
    private float initial_amount;
    @Column(name = "months", nullable = false)
    private int months;
    @Column(name = "interest_rate", nullable = false)
    private float interest_rate;
    @Column(name = "final_amount", nullable = false)
    private float final_amount;
    @Column(name = "currency_id", nullable = false)
    private int currency_id;
    @Column(name = "investor_id", nullable = false)
    private int investor_id;
}
