package com.kosta.bankservice.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bankapi")
@Getter
@Setter             // ― Lombok: 필드용 getter/setter 자동 생성
@NoArgsConstructor          // ― 기본 생성자
@AllArgsConstructor         // ― 모든 필드 생성자
@Builder                    // ― 빌더 패턴
public class BankApi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // ― AUTO_INCREMENT 매핑
    private Long id;                                      // PK

    @Column(name = "balance_amt", nullable = false, length = 50)
    private BigDecimal balanceAmt;    // 잔액 (VARCHAR → BigDecimal 매핑 권장)

    @Column(name = "account_num", nullable = false, length = 20)
    private String accountNum;        // 계좌번호

    @Column(name = "prod_name", nullable = false, length = 100)
    private String prodName;          // 계좌명(상품명)

    @Column(name = "org_name", nullable = false, length = 30)
    private String orgName;           // 은행명

    @Column(name = "member_ci", nullable = false, length = 72)
    private String memberCi;          // 사용자 식별 CI

    @Column(name = "trans_dtime", nullable = false)
    private LocalDateTime transDtime; // 거래일시

    @Column(name = "trans_amt", nullable = false, length = 50)
    private BigDecimal transAmt;      // 거래금액

    @Column(name = "trans_source", nullable = false, length = 20)
    private String transSource;       // 출처(ATM, 모바일 등)

    @Column(name = "trans_type", nullable = false, length = 20)
    private String transType;         // 타입(입금, 출금 등)
}
