package com.graphql.demo.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import com.graphql.demo.entity.Student;

@Component
public class GraphQlClient {

	@Autowired
	HttpGraphQlClient client;

	public List<Student> viewAllStudents() {

		String query = "\r\n" + "query GetAllStudents {\r\n" + "    getAllStudents {\r\n" + "        rollnum\r\n"
				+ "        name\r\n" + "        branch\r\n" + "    }\r\n" + "}\r\n" + "";
		List<Student> data = client.document(query).retrieve("getAllStudents").toEntityList(Student.class).block();
		return data;
	}

	public Student viewA_Students(int rollnum) {

		String query = String.format("query GetA_Student {\r\n" + "    getA_Student(rollnum: \"%d\") {\r\n"
				+ "        name\r\n" + "        branch\r\n" + "    }\r\n" + "}", rollnum);
		Student data = client.document(query).retrieve("getA_Student").toEntity(Student.class).block();
		return data;
	}

	public List<Student> viewStudentByBranch(String branch) {
		String query = String.format("query GetStudentByBranch {\r\n" + "    getStudentByBranch(branch: \"%s\") {\r\n"
				+ "        rollnum\r\n" + "        name\r\n" + "    }\r\n" + "}\r\n" + "", branch);
		List<Student> data = client.document(query).retrieve("getStudentByBranch").toEntityList(Student.class).block();
		return data;
	}

	public Student viewPercentage(int rollnum) {

		String query = String.format("query GetA_Student {\r\n" + "    getA_Student(rollnum:\"%d\") {\r\n"
				+ "        name\r\n" + "        percentage\r\n" + "    }\r\n" + "}\r\n" + "", rollnum);
		Student data = client.document(query).retrieve("getA_Student").toEntity(Student.class).block();
		return data;
	}

}
