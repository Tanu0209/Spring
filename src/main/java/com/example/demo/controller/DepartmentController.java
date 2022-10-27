package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.DepartmentNotFound;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Student;

@RestController
public class DepartmentController {

	Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	

	@Autowired
	DepartmentRepo repo;
	@Autowired
	StudentRepo repo1;

	@PostMapping("/department")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		logger.info("Adding data in department");
		return new ResponseEntity<Department>(repo.save(department), HttpStatus.OK);

	}

	@GetMapping("/department")
	public ResponseEntity<List<Department>> findDepartment() {
		List<Department> department = repo.findAll();
		if (department.size() > 0) {
			logger.info("Get all department data");
			return new ResponseEntity<List<Department>>(department, HttpStatus.OK);
		}
		logger.error("No department found");
		return new ResponseEntity<List<Department>>(HttpStatus.NO_CONTENT);

	}

	@PutMapping("/department/{dept_ID}/{name}")
	public ResponseEntity<Department> updateDepartmentDescription(@PathVariable int dept_ID,
			@PathVariable String name) {
		Optional<Department> optional = repo.findById(dept_ID);
		if (optional.isPresent()) {
			logger.info("Update department description");
			Department department = optional.get();
			department.setDepartmentname(name);
			Department department1 = repo.save(department);

			return new ResponseEntity<Department>(department1, HttpStatus.OK);
		}
		logger.info("Department description not updated");
		return new ResponseEntity<Department>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("department/{dept_ID}")
	public ResponseEntity<Department> deleteProject(@PathVariable int dept_ID) {
		try {
			logger.info("Delete department data by ID");
			repo.deleteById(dept_ID);
			return new ResponseEntity<Department>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error deleting department data by ID");
			return new ResponseEntity<Department>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		logger.info("Adding data in student");
		return new ResponseEntity<Student>(repo1.save(student), HttpStatus.OK);

	}

	@GetMapping("/student")
	public ResponseEntity<List> findStudent() {
		List<Student> student = repo1.findAll();
		if (student.size() > 0) {
			logger.info("Get all student data");
			System.out.println(student);
			return new ResponseEntity<List>(student, HttpStatus.OK);
		}
		logger.info("No student data found");
		return new ResponseEntity<List>(HttpStatus.NO_CONTENT);

	}

	@PutMapping("/student/{id}/{name}")
	public ResponseEntity<Student> updateStudentDescription(@PathVariable int id, @PathVariable String name) {
		Optional<Student> optional = repo1.findById(id);
		if (optional.isPresent()) {
			logger.info("Update student description");
			Student student = optional.get();
			student.setName(name);
			Student student1 = repo1.save(student);
			return new ResponseEntity<Student>(student1, HttpStatus.OK);
		}
		logger.info("Student description not updated");
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
		try {
			logger.info("Delete student by ID");
			repo1.deleteById(id);
			return new ResponseEntity<Student>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error deleting student data by ID");
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/student/{id}")
	@ExceptionHandler(value = com.example.demo.exception.StudentNotFound.class)
	public ResponseEntity<Student> findStudentById(@PathVariable int id) {
		Optional<Student> optional = repo1.findById(id);
		if (optional.isPresent()) {
			logger.info("Find student by ID");
			return new ResponseEntity<Student>(optional.get(), HttpStatus.OK);
		}
		logger.warn("Student not found");
		return new ResponseEntity("Student Not Found!", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/department/{dept_ID}")
	@ExceptionHandler(value = DepartmentNotFound.class)
	public ResponseEntity<Department> findDepartmentById(@PathVariable int dept_ID) {
		Optional<Department> optional = repo.findById(dept_ID);
		if (optional.isPresent()) {
			logger.info("Find department by specific ID");
			return new ResponseEntity<Department>(optional.get(), HttpStatus.OK);
		}
		logger.warn("Department with specific ID not present!");
		return new ResponseEntity("Department Not Found!", HttpStatus.NOT_FOUND);
	}

}
