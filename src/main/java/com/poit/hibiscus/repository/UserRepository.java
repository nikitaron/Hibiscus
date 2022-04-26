package com.poit.hibiscus.repository;

import com.poit.hibiscus.entity.Passport;
import com.poit.hibiscus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.passport = :passport WHERE u.email = :email")
    void updateUser(@Param("email") String email, @Param("passport") Passport passport);
}
