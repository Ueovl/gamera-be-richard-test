package com.avengers.gamera.repository;

import com.avengers.gamera.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsUserByEmail(String email);

    Optional<User> findByEmail(String email);
}
