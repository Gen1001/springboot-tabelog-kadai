package com.example.nagoyameshi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
