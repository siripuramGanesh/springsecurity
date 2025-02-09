package com.ganeshsiripuram.springsecurity.springsecurity.repositories;

import com.ganeshsiripuram.springsecurity.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{

Optional<User> findByEmail(String email);

}
