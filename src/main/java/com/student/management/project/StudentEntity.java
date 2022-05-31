package com.student.management.project;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	private String name ;
	private int marks;
	private int percentage;
	private String status;
	private String gender;
	@Transient
	private int reqPercentage;
	
}
