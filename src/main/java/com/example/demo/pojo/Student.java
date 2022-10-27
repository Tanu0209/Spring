package com.example.demo.pojo;

	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Transient;

	@Entity
	public class Student {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String name;
		private int roll_no;
		private int dept_ID;
		@Transient
		List<Department> department;
		public Student() {
			super();
		}
		public Student(int id, String name, int roll_no, int dept_ID, List<Department> department) {
			super();
			this.id = id;
			this.name = name;
			this.roll_no = roll_no;
			this.dept_ID = dept_ID;
			this.department = department;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getRoll_no() {
			return roll_no;
		}
		public void setRoll_no(int roll_no) {
			this.roll_no = roll_no;
		}
		public int getDept_ID() {
			return dept_ID;
		}
		public void setDept_ID(int dept_ID) {
			this.dept_ID = dept_ID;
		}
		public List<Department> getDepartment() {
			return department;
		}
		public void setDepartment(List<Department> department) {
			this.department = department;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", roll_no=" + roll_no + ", dept_ID=" + dept_ID
					+ ", department=" + department + "]";
		}
		
		
			
		
		
		
		
	}
	   
		


