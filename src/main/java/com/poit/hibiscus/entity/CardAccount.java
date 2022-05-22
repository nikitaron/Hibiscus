package com.poit.hibiscus.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "card_accounts")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CardAccount {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "money")
    private BigDecimal money;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type")
    private CurrencyType currencyType;

    @Column(name = "iban")
    private String iban;

    @Column(name = "number")
    private String number;

    @OneToMany
    @JoinColumn(name = "account_id")
    @ToString.Exclude
    private Set<Card> cards = new HashSet<>();

    @Column(name = "user_id")
    private Long userId;

    public void addMoney(BigDecimal amount) {
        money = money.add(amount);
    }

    public void subMoney(BigDecimal amount) {
        money = money.subtract(amount);
    }
}
