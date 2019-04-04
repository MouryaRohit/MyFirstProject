package com.gradleproject.studentservice;

import java.util.List;
import com.gradleproject.model.Student;

public interface StudentService {

	public void saveStudent(Student student) throws Exception;
	public Student getStudentById(int studentId) throws Exception;
	public List<Student> getAllStudents() throws Exception;
	public Student updateStudent(Student student) throws Exception;
	public void deleteStudent(int id) throws Exception;
   
	

	
	
}
