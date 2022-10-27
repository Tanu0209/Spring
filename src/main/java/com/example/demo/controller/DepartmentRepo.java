package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Student;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

	Student save(Student student);

}
