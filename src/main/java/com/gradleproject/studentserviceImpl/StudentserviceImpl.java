package com.gradleproject.studentserviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gradleproject.studentdao.StudentDao;
import com.gradleproject.model.Student;
import com.gradleproject.studentservice.*;


@Service
public class StudentserviceImpl implements StudentService{
	
	
	@Autowired
	private StudentDao studentDao;
	

	@Override
	public void saveStudent(Student student) throws Exception {
		 studentDao.saveStudent(student);
	
		
		 
		
	}

	@Override
	public Student getStudentById(int id) throws Exception {
		return studentDao.getStudentById(id);
		
	}
	
	@Override
	public List<Student> getAllStudents() throws Exception {
		return studentDao.getAllStudents();
		
	}
	
	@Override
	public Student updateStudent(Student student) throws Exception {
		 studentDao.updateStudent(student);
		return student;
		
	}

	@Override
	public void deleteStudent(int id) throws Exception {
		studentDao.deleteStudent(id);
		
	}

	

	

	



}
