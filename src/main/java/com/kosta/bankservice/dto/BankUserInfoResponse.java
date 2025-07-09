package com.kosta.bankservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankUserInfoResponse {
    private String name;
    private String email;
    private String phone;
    private String ci;
    private String bankAccount;
}
