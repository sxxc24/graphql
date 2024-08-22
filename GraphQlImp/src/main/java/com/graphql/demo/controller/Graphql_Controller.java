package com.graphql.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.demo.entity.Student;
import com.graphql.demo.repository.RtRepo;

@RestController
public class Graphql_Controller {

	@Autowired
	RtRepo repo;

	@QueryMapping
	public List<Student> getAllStudents() {
		List<Student> getallstudents = repo.findAll();
		return getallstudents;
	}

	@QueryMapping
	public Student getA_Student(@Argument int rollnum) {
		Student json = repo.findById(rollnum).get();
		return json;
	}

	@QueryMapping
	public List<Student> getStudentByBranch(@Argument String branch) {
		List<Student> json = repo.findByBranch(branch);
		return json;
	}

	@MutationMapping
	public Student addStudent(@Argument String name, @Argument String branch, @Argument float percentage) {
		Student add = new Student(name, branch, percentage);
		repo.save(add);
		return add;
	}

	@MutationMapping
	public Student updateStudentPercentage(@Argument int rollnum, @Argument float percentage) {
		Student update = repo.findById(rollnum).get();
		update.setPercentage(percentage);
		repo.save(update);
		return update;
	}

	@MutationMapping
	public boolean deleteId(@Argument int rollnum) {
		repo.deleteById(rollnum);
		return true;
	}

}
