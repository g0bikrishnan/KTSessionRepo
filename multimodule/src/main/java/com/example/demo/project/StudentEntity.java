package com.example.demo.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class StudentEntity {
	private int id;
	private  String name;
	private int marks;
	private int percentage;
	private String status;
	private String gender;
	private int reqPercentageToPass;
}
