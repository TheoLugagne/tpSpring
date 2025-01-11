package com.example.tpspringfinal.repositories;

import com.example.tpspringfinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
