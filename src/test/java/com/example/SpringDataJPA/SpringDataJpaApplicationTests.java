package com.example.SpringDataJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.awt.print.Pageable;
import java.util.List;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	EmployeeRepo employeeRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void create(){
		Employee employee = new Employee();
		employee.setName("khushwant");
		employee.setId(1);
		employee.setAge(23);
		employee.setLocation("Delhi");

		employeeRepo.save(employee);
	}

	@Test
	void update(){
		Employee employee = employeeRepo.findById(1).get();
		employee.setLocation("NewDelhi");
		employeeRepo.save(employee);
	}

	@Test
	void delete(){
		if (employeeRepo.existsById(1)){
			employeeRepo.deleteById(1);
		}


	}

	@Test
	void read(){
		Employee employee = employeeRepo.findById(1).get();
		System.out.printf(String.valueOf(employee));
	}

	@Test
	void count(){
		System.out.printf("Total " + employeeRepo.count());
	}


	@Test
	void findByName(){
		List<Employee> list = employeeRepo.findByName("Khushwant");
		System.out.printf(list.toString());
	}

	@Test
	void findByNameContains(){
		List<Employee> list = employeeRepo.findByNameStartingWith("a");
		System.out.printf(list.toString());
	}


	@Test
	void findByAgeBetween(){
		List<Employee> list = employeeRepo.findByAgeBetween(23,32);
		System.out.printf(list.toString());
	}

	@Test
	void findAllPagingAndSorting(){
		PageRequest pageable = PageRequest.of(0,1,Direction.ASC,"age");
		employeeRepo.findAll(pageable).forEach(i -> System.out.printf(i.toString()));
	}


}
