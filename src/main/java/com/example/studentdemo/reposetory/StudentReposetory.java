package com.example.studentdemo.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentdemo.model.Student;

@Repository
public interface StudentReposetory extends JpaRepository<Student, Integer> {

}
