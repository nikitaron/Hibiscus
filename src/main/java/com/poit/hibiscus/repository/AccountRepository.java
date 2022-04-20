package com.poit.hibiscus.repository;

import com.poit.hibiscus.entity.CardAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<CardAccount, Long> {
}
