package com.graphql.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.demo.entity.Student;

@Repository
public interface RtRepo extends JpaRepository<Student, Integer> {
	List<Student> findByBranch(String branch);

}
