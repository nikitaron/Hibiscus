package com.poit.hibiscus.repository;

import com.poit.hibiscus.entity.SNS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnsRepository extends JpaRepository<SNS, Long> {
}
