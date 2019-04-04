package com.gradleproject.studentcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.gradleproject.model.Student;
import com.gradleproject.studentservice.StudentService;

@RestController
@RequestMapping(value="/user")
public class StudentController{
	
	@Autowired
	private StudentService studentService;
	
	
	 @RequestMapping(value="/student" ,method = RequestMethod.POST)
	 public @ResponseBody String saveStudent(@RequestBody Student student) throws Exception{
		 try {
			 studentService.saveStudent(student);
			 
		 }catch(Exception e){			 
			 e.printStackTrace();
	    		return e.toString();			 
		 }	
		 return "records saved successfully";
	 }
	 
	@RequestMapping(value="/student/{id}",method = RequestMethod.GET)
	 public @ResponseBody Student getStudentById(@PathVariable int id) throws Exception {
		
			 return studentService.getStudentById(id); 
	 }
	 
	 @RequestMapping(value="/students" ,method = RequestMethod.GET)
	 public @ResponseBody List<Student> getAllStudents() throws Exception{
		 
		 return studentService.getAllStudents();
	 
	 }
	 
	 @RequestMapping(value="/student",method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String updateStudent(@RequestBody Student student) throws Exception{
			try{
				studentService.updateStudent(student);
				return "updated Successfully";
				  
	 }catch(Exception e){			 
			 e.printStackTrace();
	    		return e.toString();
			 
		 }
		 
 }
	 @RequestMapping(value="/student/{id}",method = RequestMethod.DELETE)
	 public @ResponseBody String deleteStudent(@PathVariable("id") int id) throws Exception {
		 try {
			
			 studentService.deleteStudent(id);
			 
		 }catch(Exception e){			 
			 e.printStackTrace();
	    		return e.toString();
			 
		 }
		 return "record deleted successfully";
	 }
	 
	
	     
	 

}