package com.Salesken.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.Salesken.Model.Student;

public interface StudentRepo extends ElasticsearchRepository<Student, Integer>{

}
