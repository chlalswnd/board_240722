package com.boot.board_240718.repository;

import com.boot.board_240718.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}