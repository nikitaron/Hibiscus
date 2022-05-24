package com.poit.hibiscus.repository;

import com.poit.hibiscus.entity.CardAccount;
import com.poit.hibiscus.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface AccountTransactionRepository extends JpaRepository<Transactions.AccountTransaction, UUID> {

/*    @Modifying
    @Query("""
            
            """)
    void executeTransaction(@Param("fromAccount") CardAccount cardAccount,
                            @Param("toAccount") CardAccount toAccount,
                            @Param("amount") BigDecimal amount);*/
}
