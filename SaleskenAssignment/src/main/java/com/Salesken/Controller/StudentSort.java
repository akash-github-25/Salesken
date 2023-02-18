package com.Salesken.Controller;

import org.apache.logging.log4j.util.PropertySource.Comparator;

import com.Salesken.Model.Student;

public class StudentSort implements java.util.Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		if(o1.getTotalMarks()>o2.getTotalMarks()) {
			return 1;
		}else {
			return -1;
		}
	}

}
