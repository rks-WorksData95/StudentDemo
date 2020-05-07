package com.example.studentdemo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.studentdemo.model.Student;
import com.example.studentdemo.reposetory.StudentReposetory;

@RestController
public class studentController {
	
	@Autowired
	StudentReposetory studentReposetory;
	
	
	
	@GetMapping(path="/getStudents")
	public List<Student> getStudents(){
		return studentReposetory.findAll();
	}
	
	@GetMapping(path="/getStudent/{id}")
	public Student getStudent(@PathVariable int id){
		return studentReposetory.findById(id).get();
	}
	
	@PostMapping(path="/saveStudent")
	public ResponseEntity<Object> saveStudent(@RequestBody Student student){
		studentReposetory.save(student);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path="/deleteStudent/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id){
		studentReposetory.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path="/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		studentReposetory.save(student);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
}
