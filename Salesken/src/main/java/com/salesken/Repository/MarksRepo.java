package com.salesken.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesken.Bean.Marks;

@Repository
public interface MarksRepo extends JpaRepository<Marks, Integer>{

}
