package com.gradleproject.studentdaoImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import javax.transaction.Transactional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.gradleproject.studentdao.StudentDao;
import com.gradleproject.model.Student;

@Transactional
@Repository
public class StudentsDaoImpl implements StudentDao{
	
	@PersistenceContext
    private EntityManager entityManager;

	

	@Override
	public void saveStudent(Student student) {
	 entityManager.persist(student);
		
	}
	
	@Override
	public Student getStudentById(int id) {
		
		return  entityManager.find(Student.class,id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents(){
		return entityManager.createNativeQuery("SELECT * FROM Student").getResultList();
		
	}
	
	@Override
	public void updateStudent(Student student) {
	
		 entityManager.merge( student);
	}
	@Override
	public void deleteStudent(int id) {
		
		Student st= entityManager.find(Student.class, id);
		if(st!=null) {
			entityManager.remove(st);
		}
	}

	
	

	
	
	
}
	
