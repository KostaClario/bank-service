package com.kosta.bankservice.domain.repository;

import com.kosta.bankservice.domain.entity.BankApi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankApiRepository extends JpaRepository<BankApi, Long> {
    List<BankApi> findByMemberCiOrderByTransDtimeDesc(String memberCi);
}
