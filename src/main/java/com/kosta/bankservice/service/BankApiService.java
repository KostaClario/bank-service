package com.kosta.bankservice.service;


import com.kosta.bankservice.domain.entity.BankApi;
import com.kosta.bankservice.domain.repository.BankApiRepository;
import com.kosta.bankservice.dto.BankApiDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankApiService {

    private final BankApiRepository bankApiRepository;

    public BankApiService(BankApiRepository bankApiRepository) {
        this.bankApiRepository = bankApiRepository;
    }

    public List<BankApiDTO> getBankTransactionByCi(String memberCi) {
        List<BankApi> bankApiList = bankApiRepository.findByMemberCiOrderByTransDtimeDesc(memberCi);

        return bankApiList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private BankApiDTO convertToDTO(BankApi bankApi) {
        return BankApiDTO.builder()
                .accountNum(bankApi.getAccountNum())
                .prodName(bankApi.getProdName())
                .orgName(bankApi.getOrgName())
                .balanceAmt(bankApi.getBalanceAmt())
                .transAmt(bankApi.getTransAmt())
                .transSource(bankApi.getTransSource())
                .transType(bankApi.getTransType())
                .transDtime(bankApi.getTransDtime())
                .build();
    }
}
