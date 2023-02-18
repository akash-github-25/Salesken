package com.salesken.Bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Integer studentId;
private String name;
private String email;

@JsonIgnore
@ManyToMany(cascade = CascadeType.ALL,mappedBy = "students")
private List<Marks> marks;

}
