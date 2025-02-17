package com.gabrielfernandes.giro_tech.entity;

import java.sql.Date;

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
@Table(name = "exchange_rates")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "daily_variation", nullable = false)
    private float dailyVariation;
    @Column(name = "daily_rate", nullable = false)
    private float dailyRate;
    @ManyToOne
    @JoinColumn(name = "currencyId", nullable = false)
    private Currency currency;
}
