package com.poit.hibiscus.repository;

import com.poit.hibiscus.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.UUID;

public interface CardTransactionRepository extends JpaRepository<Transactions.CardTransaction, UUID> {
    @Procedure(procedureName = "made_account_transaction")
    boolean madeAccountTransaction(long toCardId,
                                   long fromCardId,
                                   BigDecimal amount,
                                   String currencies);

    @Query(value = """
        SELECT id FROM cards WHERE number = :number
        """, nativeQuery = true)
    Long findCardIdByCardNumber(@Param("number") String number);
}
