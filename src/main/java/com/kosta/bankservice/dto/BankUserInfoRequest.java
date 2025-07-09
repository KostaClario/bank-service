package com.kosta.bankservice.dto;


import lombok.Data;

@Data
public class BankUserInfoRequest {

    private String email;
    private String phone;
}
