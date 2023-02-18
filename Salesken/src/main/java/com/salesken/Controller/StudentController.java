package com.salesken.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.Bean.Marks;
import com.salesken.Bean.Student;
import com.salesken.Exception.MarksException;
import com.salesken.Exception.StudentException;
import com.salesken.Service.StudentService;



@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student student) throws StudentException {
		Student addedStudent=studentService.addStudent(student);
		return addedStudent;
	}
	
	@PostMapping("/addMarks/{studentId}")
	public Marks addMarks(@PathVariable("studentId") Integer studentId, @RequestBody Marks marks) throws MarksException {
		return studentService.giveMarks(studentId, marks);
	}
	
	@GetMapping("/getAvgBySem/{semesterId}")
	public float avgOfAllStudentInSem(@PathVariable("semesterId") Integer semesterId) throws StudentException {
		return studentService.averageOfAllStudentInSem(semesterId);
	}
	
	@GetMapping("/getAvgAcrossSem/{studentId}/{subject}")
	public double avgOfOneSubjectAcrossSem(@PathVariable("studentId") Integer studentId,@PathVariable("subject") String subject) throws StudentException {
		return studentService.averageOfOneSubjectOfStudentAccrossSem(studentId, subject);
	}
	@GetMapping("/getTwoConsistentTopPerformerAcrossSem")
	public List<Student> twoConsitentTopPerformerAcrossSem() throws StudentException{
		return studentService.topTwoConsistentPerformer();
	}

}
