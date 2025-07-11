package com.kosta.bankservice.controller;


import com.kosta.bankservice.dto.BankUserInfoRequest;
import com.kosta.bankservice.dto.BankUserInfoResponse;
import com.kosta.bankservice.util.CiGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
public class BankUserController {

    @PostMapping("/user-info")
    public BankUserInfoResponse getUserInfo(@RequestBody BankUserInfoRequest request) {
        String ci = CiGenerator.generateCi(request.getEmail(), request.getPhone());

        return BankUserInfoResponse.builder()
                .name("임태빈")
                .email(request.getEmail())
                .phoneNum(request.getPhone())
                .memberCi(ci)
                .bankAccount("110-1111-2222")
                .build();
    }
}
