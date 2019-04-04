package com.gradleproject.studentdao;


import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.gradleproject.model.Student;



public interface StudentDao 
{
	
	
		@Query(value="INSERT INTO Student (first_name,last_name,sub) VALUES (?,?,?)",
			nativeQuery=true
				)
	 	public void saveStudent(Student student);
		
		
		
	 	@Query(value="SELECT s FROM Student s WHERE s.id = id",
	 	nativeQuery = true
	 	)
	    public Student getStudentById(int id);
	 	
	 	@Query(value = "SELECT * FROM Student ",
	            nativeQuery=true
	    )
	    public List<Student> getAllStudents();
	 	
	 	@Modifying
	    @Query(value="Update Student s set  s.first_name=s.getFirstName() ,s.last_name=? ,s.sub=? where s.id=?",
	    		nativeQuery = true
	    		)
	    public void updateStudent(Student student);
	 	
	 	
	 	
	 	@Modifying
	    @Query(value="Delete from Student s where s.id=?",
	    		nativeQuery = true
	    		)
	    public void deleteStudent(int id);
	 	
	 	
	 	
	
}
