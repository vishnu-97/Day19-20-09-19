package com.genesis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.dao.StudentDAO;
import com.genesis.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public void studentEntry(Student student) {
		studentDAO.addStudent(student);
	}

	@Override
	public void deleteStudent(int code) {
		studentDAO.removeStudent(code);
	}

	@Override
	public void changeStudentDetails(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public Student searchStudent(int code) {
		return studentDAO.getStudentById(code);
	}

	@Override
	public List<Student> viewAllStudents() {
		return studentDAO.getAllStudents();
	}

	
}
