package com.salesken.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesken.Bean.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
