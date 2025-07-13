package com.kosta.bankservice.controller;


import com.kosta.bankservice.dto.BankApiDTO;
import com.kosta.bankservice.service.BankApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/internal")
public class BankApiController {

    private final BankApiService bankApiService;

    public BankApiController(BankApiService bankApiService) {
        this.bankApiService = bankApiService;
    }


    @GetMapping("/transactions/{memberCi}")
    public ResponseEntity<List<BankApiDTO>> getTransactions(@PathVariable String memberCi) {
        List<BankApiDTO> transactions = bankApiService.getBankTransactionByCi(memberCi);
        return ResponseEntity.ok(transactions);
    }
}
