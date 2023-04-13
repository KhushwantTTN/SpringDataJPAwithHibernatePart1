package com.example.SpringDataJPA;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>,
        PagingAndSortingRepository<Employee,Integer> {

    List<Employee> findByName(String name);

    List<Employee> findByNameStartingWith(String name);

    List<Employee> findByAgeBetween(int one , int two);


}
