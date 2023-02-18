package com.salesken.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.Bean.Marks;
import com.salesken.Bean.Student;
import com.salesken.Exception.MarksException;
import com.salesken.Exception.StudentException;
import com.salesken.Repository.MarksRepo;
import com.salesken.Repository.StudentRepo;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private MarksRepo marksRepo;

	@Override
	public Student addStudent(Student student) throws StudentException {
		
		Student newStudent=studentRepo.save(student);
		if(newStudent!=null) {
			return newStudent;
		}else {
			throw new StudentException("Student can't be added");
		}
		
	}

	@Override
	public Marks giveMarks(Integer studentId, Marks marks) throws MarksException {
		
		Marks newMarks=marksRepo.save(marks);
		if(newMarks!=null) {
		Integer newStudentId=marks.getStudentId();
		Optional<Student> opt=studentRepo.findById(newStudentId);
		Student newStudent = opt.get();
		List<Marks> resMarks=newStudent.getMarks();
		resMarks.add(newMarks);
		newStudent.setMarks(resMarks);
		studentRepo.save(newStudent);
		return newMarks;
		}else {
			throw new MarksException("Marks can't be provided to that student");
		}
	}

	@Override
	public float averageOfAllStudentInSem(Integer semesterId) throws StudentException {
		

		int sum=0;
		int count=0;

		List<Marks> marks = marksRepo.findAll();
		
			for(Marks d:marks) {			
				if(d.getSemesterId()==semesterId) {
				sum=sum+d.getEnglish()+d.getScience()+d.getMaths();
				count++;
				}
			}
		
		int t=3*count;
		return Math.round((double)sum/t);
	}

	@Override
	public double averageOfOneSubjectOfStudentAccrossSem(Integer studentId,String subject) throws StudentException {
		
		int sum1=0;
		int count=0;
		if(subject.equalsIgnoreCase("English")) {
			List<Marks> allMarks=marksRepo.findAll();
			List<Marks> marks=allMarks.stream().filter((s)->s.getStudentId()==studentId).collect(Collectors.toList());
			for(Marks d:marks) {
				sum1=sum1+d.getEnglish();
				count++;
			}
		}else if(subject.equalsIgnoreCase("Science")) {
			
			List<Marks> allMarks=marksRepo.findAll();
			List<Marks> marks=allMarks.stream().filter((s)->s.getStudentId()==studentId).collect(Collectors.toList());
			
			for(Marks d:marks) {
				sum1=sum1+d.getScience();
				count++;
			}
			
		}else {
			List<Marks> allMarks=marksRepo.findAll();
			List<Marks> marks=allMarks.stream().filter((s)->s.getStudentId()==studentId).collect(Collectors.toList());
			for(Marks d:marks) {
				sum1=sum1+d.getMaths();
				count++;
			}
		}	
		return Math.round((double)(sum1/count));
	}

	@Override
	public List<Student> topTwoConsistentPerformer() throws StudentException {
		List<Student> newStudent=studentRepo.findAll();
		Collections.sort(newStudent,new SortStudent());
		List<Student> students=new ArrayList<>();
		students.add(newStudent.get(0));
		students.add(newStudent.get(1));
		return students;
	}

}
