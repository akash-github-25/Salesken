package com.salesken.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Marks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer marksId;
	private Integer SemesterId;
	private Integer Maths;
	private Integer Science;
	private Integer English;
	private Integer studentId;
	
	@JsonIgnore
	@ManyToMany
	List<Student> students=new ArrayList<>();
	

}
