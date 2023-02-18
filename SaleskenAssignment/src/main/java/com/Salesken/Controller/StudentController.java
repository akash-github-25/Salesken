package com.Salesken.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Salesken.Exception.StudentException;
import com.Salesken.Model.Student;
import com.Salesken.Repository.StudentRepo;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) throws StudentException {
		return new ResponseEntity<>(studentRepo.save(student),HttpStatus.OK);
	}
	
	@GetMapping("/getAvgBySem/{semesterId}")
	public String avgOfAllStudentInSem(@PathVariable("semesterId") Integer semesterId) throws StudentException {	
		
		Iterable<Student> itr= studentRepo.findAll(); 
		 List<Student> students= new ArrayList<>();
		 itr.forEach(students::add);
		 int sum=0;
		 int count=0;
		 for(Student d:students) {
			 if(d.getSemester()==semesterId) {
				 sum=sum+d.getEnglish()+d.getMaths()+d.getScience();
				 count++;
			 }
		 }
		 int t=3*count;
		return Math.round((double)sum/t)+" is the required Average";
		
	}
	
	@GetMapping("/getAvgAcrossSem/{studentId}/{subject}")
	public String avgOfOneSubjectAcrossSem(@PathVariable("studentId") Integer studentId,@PathVariable("subject") String subject) throws StudentException {
		
		 
		 int sum1=0;
			int count=0;
			if(subject.equalsIgnoreCase("English")) {
				Iterable<Student> itr= studentRepo.findAll(); 
				 List<Student> students= new ArrayList<>();
				 itr.forEach(students::add);
				
				for(Student d:students) {
					sum1=sum1+d.getEnglish();
					count++;
				}
			}else if(subject.equalsIgnoreCase("Science")) {
				
				Iterable<Student> itr= studentRepo.findAll(); 
				 List<Student> students= new ArrayList<>();
				 itr.forEach(students::add);
				
				for(Student d:students) {
					sum1=sum1+d.getScience();
					count++;
				}
				
			}else {
				Iterable<Student> itr= studentRepo.findAll(); 
				 List<Student> students= new ArrayList<>();
				 itr.forEach(students::add);
				for(Student d:students) {
					sum1=sum1+d.getMaths();
					count++;
				}
			}	
			return Math.round((double)(sum1/count))+" is the required Avergae of one student across semester";
	}
	
	@GetMapping("/getTwoConsistentTopPerformerAcrossSem")
	public String twoConsitentTopPerformerAcrossSem(Model model) throws StudentException{
		
		Iterable<Student> itr= studentRepo.findAll();
		 
		 List<Student> students= new ArrayList<>();
		 itr.forEach(students::add);
		 
		 Collections.sort(students,new StudentSort());
		 
		 model.addAttribute("studentData", students);
		 
		 return students+"";
	}
	
	

}
