package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
