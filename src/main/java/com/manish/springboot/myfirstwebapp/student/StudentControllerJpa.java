package com.manish.springboot.myfirstwebapp.student;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("classname")
public class StudentControllerJpa {

//	private TodoService todoService;
	private StudentRepository studentRepository;

	public StudentControllerJpa(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@RequestMapping("list-students")
	public String listAllStudents(ModelMap model) {
		String classname = getLoggedinClassname(model);
		List<Student> students = studentRepository.findByClassname(classname);
		model.put("students", students);
		return "listStudents";
	}

	@RequestMapping(value = "add-student", method = RequestMethod.GET)
	public String showNewStudentPage(ModelMap model) {
		String classname = getLoggedinClassname(model); 
		Student student = new Student(0, 0,"", classname, 0, 0, 0, 0, "");
		model.put("student", student);
		return "student";
	}

	@RequestMapping(value = "add-student", method = RequestMethod.POST)
	public String addNewStudent(ModelMap model, @Valid Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "student";
		}
		String classname = getLoggedinClassname(model);
		Float perc = ((float) (student.getMarks1() + student.getMarks2() + student.getMarks3()) / 300.0f) * 100.0f;
		String formattedPerc = String.format("%.2f", perc);  
		student.setPercentage(Float.parseFloat(formattedPerc));

		if (perc >= 80.0) {
		    student.setResult("A");
		} else if (perc >= 60.0 && perc < 80.0) {
		    student.setResult("B");
		} else if (perc >= 40.0 && perc < 60.0) {
		    student.setResult("C");
		} else {
		    student.setResult("F");
		}

		student.setClassname(classname);
		studentRepository.save(student); 
		return "redirect:list-students";
	}

	@RequestMapping("delete-student")
	public String deleteStudent(@RequestParam int id) { 
		studentRepository.deleteById(id);

		return "redirect:list-students";
	}

	@RequestMapping(value = "update-student", method = RequestMethod.GET)
	public String showUpdateStudentPage(ModelMap model, @RequestParam int id) {
		Student student = studentRepository.findById(id).get();
		model.addAttribute("student", student);
		return "student";
	}

	@RequestMapping(value = "update-student", method = RequestMethod.POST)
	public String updateStudent(ModelMap model, @Valid Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "student";
		}
		Float perc = ((float) (student.getMarks1() + student.getMarks2() + student.getMarks3()) / 300.0f) * 100.0f;
		String formattedPerc = String.format("%.2f", perc);  
		student.setPercentage(Float.parseFloat(formattedPerc));

		if (perc >= 80.0) {
		    student.setResult("A");
		} else if (perc >= 60.0 && perc < 80.0) {
		    student.setResult("B");
		} else if (perc >= 40.0 && perc < 60.0) {
		    student.setResult("C");
		} else {
		    student.setResult("F");
		}


		String classname = getLoggedinClassname(model);
		student.setClassname(classname);
		studentRepository.save(student);
		return "redirect:list-students";
	}

//	private String getLoggedinClassname(ModelMap model) {
//		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
//				.getAuthentication();
//
//		return authentication.getPrincipal().toString();
//	}
	private String getLoggedinClassname(ModelMap model) {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();

		if (authentication != null
				&& authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User) {
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication
					.getPrincipal();
 
			return user.getUsername();
		}

		return "DefaultClassName";  
	}

}
