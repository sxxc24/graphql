package com.graphql.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.demo.client.GraphQlClient;
import com.graphql.demo.entity.PercentUpdate;
import com.graphql.demo.entity.Student;
import com.graphql.demo.repository.RtRepo;

@RestController

public class RestGraphqlController {

	@Autowired
	GraphQlClient client;
	@Autowired
	RtRepo repo;

	// fetching
	@GetMapping("students")
	public List<Student> getAllStudents() {
		return client.viewAllStudents();
	}

	@GetMapping("studentsByRollnum/{rollnum}")
	public Student getAllStudents(@PathVariable int rollnum) {
		return client.viewA_Students(rollnum);
	}

	@GetMapping("studentsByBranch/{branch}")
	public List<Student> getStudentByBranch(@PathVariable String branch) {
		return client.viewStudentByBranch(branch);
	}

	@GetMapping("studentsByPercentage/{rollnum}")
	public Student getStudentByBranch(@PathVariable int rollnum) {
		return client.viewPercentage(rollnum);
	}

	// adding
	@PostMapping("add")
	public int addStudentJson(@RequestBody Student data) {
		repo.save(data);
		return data.getRollnum();
	}

	// updating
	@PutMapping("update")
	public void updateStudentPercetage(@RequestBody PercentUpdate data) {
		Student sdata = repo.findById(data.getRollnum()).get();
		sdata.setPercentage(data.getPercentage());
		repo.save(sdata);

	}

	@DeleteMapping("delete/{rollnum}")
	public boolean deleteStudentData(@PathVariable int rollnum) {
		repo.deleteById(rollnum);
		return true;
	}

}
