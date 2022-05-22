package com.poit.hibiscus.repository;

import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.entity.CardAccount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> getAllByUserId(Long id);
    Card getCardByNumber(String num);
}
