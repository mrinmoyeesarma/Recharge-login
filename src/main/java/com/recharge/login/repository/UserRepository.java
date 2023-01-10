package com.recharge.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recharge.login.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsernameAndPasswordAndIsAdmin(String username,String password,boolean isAdmin);
}
