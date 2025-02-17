package com.gabrielfernandes.giro_tech.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielfernandes.giro_tech.service.InvestorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/investors")
public class InvestorController {
    private final InvestorService investorService;
}
