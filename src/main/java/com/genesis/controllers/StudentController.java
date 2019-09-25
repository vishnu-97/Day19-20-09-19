package com.genesis.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.genesis.entities.Student;
import com.genesis.services.StudentService;
import com.genesis.services.StudentServiceImpl;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping("change")
	public ModelAndView update(@RequestParam("id") int code){
		ModelAndView mv=new ModelAndView("updatestudent");
		mv.addObject("student", studentService.searchStudent(code));
		return mv;
	}
	
	@RequestMapping("changestudent")
	public ModelAndView updateStudent(@ModelAttribute Student student){
		studentService.changeStudentDetails(student);
		ModelAndView mv=new ModelAndView("redirect:viewall");
		return mv;
	}
	@RequestMapping("removestudent")
	public ModelAndView deleteStudent(@RequestParam("id") int code){
		studentService.deleteStudent(code);
		ModelAndView mv=new ModelAndView("redirect:viewall");
		return mv;
	}
	
	@RequestMapping("viewall")
	public ModelAndView showAllRecords(HttpServletRequest request){
		List<Student> students=studentService.viewAllStudents();
		ModelAndView mv;
		mv=new ModelAndView("studentlist");
		mv.addObject("id",request.getParameter("id"));
		mv.addObject("students", students);
		return mv;
	}
	
	
	
	@RequestMapping("dataentry")
	public ModelAndView showDataEntryForm(){
		ModelAndView mv=new ModelAndView("dataentry");
		mv.addObject("student",new Student());
		return mv;
	}
	
	@RequestMapping("savestudent")
	public ModelAndView saveStudentInfo(@Valid @ModelAttribute("student") Student student,BindingResult br){
		if(br.hasErrors()) {
			ModelAndView mv=new ModelAndView("dataentry");
			return mv;
		}
		studentService.studentEntry(student);
		ModelAndView mv=new ModelAndView("saveconfirm");
		return mv;
	}
	
}

//ModelAndView mv=new ModelAndView("redirect:viewallstudents");
