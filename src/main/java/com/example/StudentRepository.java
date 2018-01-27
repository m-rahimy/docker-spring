package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    Customer findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);

}