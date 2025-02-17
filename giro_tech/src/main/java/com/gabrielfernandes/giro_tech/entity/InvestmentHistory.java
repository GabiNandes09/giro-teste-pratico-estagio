package com.gabrielfernandes.giro_tech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "investiment_historys")
public class InvestmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "initial_amount", nullable = false)
    private float initialAmount;
    @Column(name = "months", nullable = false)
    private int months;
    @Column(name = "interest_rate", nullable = false)
    private float interestRate;
    @Column(name = "final_amount", nullable = false)
    private float finalAmount;
    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private CurrencyEntity currency;
    @JoinColumn(name = "investor_id", nullable = false)
    private Investor investor;
}
