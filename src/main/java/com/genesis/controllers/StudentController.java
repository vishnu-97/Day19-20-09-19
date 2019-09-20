package com.genesis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.genesis.entities.Student;
import com.genesis.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("removestudent")
	public ModelAndView deleteStudent(@RequestParam("id") int code){
		studentService.deleteStudent(code);
		ModelAndView mv=new ModelAndView("redirect:viewall");
		return mv;
	}
	
	@RequestMapping("viewall")
	public ModelAndView showAllRecords(){
		List<Student> students=studentService.viewAllStudents();
		ModelAndView mv=new ModelAndView("studentlist");
		mv.addObject("students", students);
		return mv;
	}
	
	
	
	@RequestMapping("dataentry")
	public String showDataEntryForm(){
		return "dataentry";
	}
	
	@RequestMapping("savestudent")
	public ModelAndView saveStudentInfo(@ModelAttribute("student") Student student){
		studentService.studentEntry(student);
		ModelAndView mv=new ModelAndView("saveconfirm");
		return mv;
	}
	
}

//ModelAndView mv=new ModelAndView("redirect:viewallstudents");
