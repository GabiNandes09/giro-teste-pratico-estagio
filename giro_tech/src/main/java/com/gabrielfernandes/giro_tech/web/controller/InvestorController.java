package com.gabrielfernandes.giro_tech.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfernandes.giro_tech.entity.Investor;
import com.gabrielfernandes.giro_tech.service.InvestorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/investors")
public class InvestorController {
    private final InvestorService investorService;

    @PostMapping
    public ResponseEntity<Investor> create(@RequestBody Investor investor){
        Investor investorResponse = investorService.save(investor);
        return ResponseEntity.status(HttpStatus.CREATED).body(investorResponse);
    }

    @GetMapping
    public ResponseEntity<List<Investor>> getAll(){
        List<Investor> response = investorService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Investor> delete(@PathVariable int id){
        investorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
