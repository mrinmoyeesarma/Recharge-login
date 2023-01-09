package com.recharge.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recharge.login.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
