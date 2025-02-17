package com.gabrielfernandes.giro_tech.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfernandes.giro_tech.entity.InvestmentHistory;
import com.gabrielfernandes.giro_tech.service.InvestmentHistoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/investments")
public class InvestmentHistoryController {
    private final InvestmentHistoryService investmentHistoryService;

    @PostMapping
    public ResponseEntity<InvestmentHistory> create(@RequestBody InvestmentHistory investmentHistory){
        InvestmentHistory investmentHistoryResponse = investmentHistoryService.save(investmentHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(investmentHistoryResponse);
    }

    @GetMapping
    public ResponseEntity<List<InvestmentHistory>> getAll(){
        List<InvestmentHistory> response = investmentHistoryService.getAll();
        return ResponseEntity.ok().body(response);
    }
}
