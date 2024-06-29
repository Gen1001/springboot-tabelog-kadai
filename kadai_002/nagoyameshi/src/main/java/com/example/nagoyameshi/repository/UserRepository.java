package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public Page<User> findByNameLike(String keyword, Pageable pageable);
	public List<User> findByRoleId(int id);
	public List<User> findByJobIdAndRoleId(int jobId, int roleId);
	public User findByEmail(String email);
}