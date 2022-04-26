package com.poit.hibiscus.repository;

import com.poit.hibiscus.entity.CardAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<CardAccount, Long> {
    Optional<CardAccount> findByIban(String iban);
}
