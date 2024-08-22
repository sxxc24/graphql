package com.graphql.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class PercentUpdate {
	int rollnum;
	float percentage;

	PercentUpdate() {

	}

	public int getRollnum() {
		return rollnum;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setRollnum(int rollnum) {
		this.rollnum = rollnum;
	}

	public void setPercentage(float percent) {
		this.percentage = percent;
	}

	@Override
	public String toString() {
		return "PercentUpdate [rollnum=" + rollnum + ", percent=" + percentage + "]";
	}

}
