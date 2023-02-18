package com.Salesken.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "Student")
public class Student {
	
	@Id
	private Integer studentId;
	private String name;
	private Integer Science;
	private Integer Maths;
	private Integer English;
	private Integer semester;
	private Integer totalMarks;
	
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = this.English+this.Science+this.Maths;
	}
	
	

}
