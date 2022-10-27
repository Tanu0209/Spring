package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dept_ID;
	private String name;
	private String head_of_dept;
	private int num_of_sems;
	public Department() {
		super();
	}
	public Department(int dept_ID, String name, String head_of_dept, int num_of_sems) {
		super();
		this.dept_ID = dept_ID;
		this.name = name;
		this.head_of_dept = head_of_dept;
		this.num_of_sems = num_of_sems;
	}
	public int getDept_ID() {
		return dept_ID;
	}
	public void setDept_ID(int dept_ID) {
		this.dept_ID = dept_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHead_of_dept() {
		return head_of_dept;
	}
	public void setHead_of_dept(String head_of_dept) {
		this.head_of_dept = head_of_dept;
	}
	public int getNum_of_sems() {
		return num_of_sems;
	}
	public void setNum_of_sems(int num_of_sems) {
		this.num_of_sems = num_of_sems;
	}
	@Override
	public String toString() {
		return "Department [dept_ID=" + dept_ID + ", name=" + name + ", head_of_dept=" + head_of_dept + ", num_of_sems="
				+ num_of_sems + "]";
	}
	public void setDepartmentname(String name2) {
		// TODO Auto-generated method stub
		
	}
	
	

}
