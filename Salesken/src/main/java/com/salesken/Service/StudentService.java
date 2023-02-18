package com.salesken.Service;

import java.util.List;

import com.salesken.Bean.Marks;
import com.salesken.Bean.Student;
import com.salesken.Exception.MarksException;
import com.salesken.Exception.StudentException;



public interface StudentService {
	
	public Student addStudent(Student student) throws StudentException;
	public Marks giveMarks(Integer studentId,Marks marks) throws MarksException;
	public float averageOfAllStudentInSem(Integer semesterId)throws StudentException;
	public double averageOfOneSubjectOfStudentAccrossSem(Integer studentId,String subject)throws StudentException;
	public List<Student> topTwoConsistentPerformer() throws StudentException;
	

}
