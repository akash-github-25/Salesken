package com.salesken.Service;

import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.Bean.Marks;
import com.salesken.Bean.Student;
import com.salesken.Repository.MarksRepo;



@Service
public class SortStudent implements Comparator<Student>{
	
	@Autowired
	private MarksRepo marksRepo;

	@Override
	public int compare(Student o1, Student o2) {
		
		List<Marks> marks1=o1.getMarks();
		List<Marks> marks2=o2.getMarks();
		int sum1=0;
		int sum2=0;
		
		for(Marks g:marks1) {
			sum1=sum1+g.getEnglish()+g.getMaths()+g.getScience();
		}
		for(Marks f:marks2) {
			sum2=sum2+f.getEnglish()+f.getMaths()+f.getScience();
		}
		if(sum1>sum2) {
			return 1;
		}else {
			return -1;
		}
	}

}
