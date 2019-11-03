package com.kevin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.domain.Tasks;

@Repository
public interface TodoRepository extends JpaRepository<Tasks, Integer>
{
	
}
