package com.poit.hibiscus.repository;

import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByCard(Card card);
}
