package com.poit.hibiscus.entity;

import java.util.HashSet;
import java.util.Set;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "cards")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Card {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pin")
    private String pin;

    @Column(name = "number")
    private String number;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "account_id")
    private Long accountId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id")
    private Set<Transaction> transactions  = new HashSet<>();;
}
