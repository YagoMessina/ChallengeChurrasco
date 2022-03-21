package com.yago.churrasco.repository;

import com.yago.churrasco.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User u WHERE u.email = :username OR u.username = :username")
    User findByUsernameOrEmail(@Param("username") String username);
}
