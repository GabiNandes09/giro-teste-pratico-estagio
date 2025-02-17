package com.gabrielfernandes.giro_tech.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "currencies")
public class CurrencyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<ExchangeRate> ExchangeRates = new ArrayList<>();

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<InvestmentHistory> investimentHistories = new ArrayList<>();
}
