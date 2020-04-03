package com.example.demoone.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.model.Student;



@Component
public interface StudentRepository  extends CrudRepository<Student, Integer>{

}
