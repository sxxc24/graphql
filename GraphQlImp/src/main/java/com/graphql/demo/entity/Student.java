package com.graphql.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentrest")
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // this will remove null , o value data while using graphql
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollnum;
	private String name;
	private String branch;
	private float percentage;

	Student() {

	}

	public Student(String name, String branch, float percentage) {
		this.name = name;
		this.branch = branch;
		this.percentage = percentage;
	}

	public int getRollnum() {
		return rollnum;
	}

	public String getName() {
		return name;
	}

	public String getBranch() {
		return branch;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setRollnum(int rollnum) {
		this.rollnum = rollnum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Student [rollnum=" + rollnum + ", name=" + name + ", branch=" + branch + ", percentage=" + percentage
				+ "]";
	}

}
