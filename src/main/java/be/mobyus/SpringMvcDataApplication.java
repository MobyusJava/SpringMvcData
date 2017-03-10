package be.mobyus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import be.mobyus.dao.CompetenceRepository;
import be.mobyus.dao.EmployeeRepository;
import be.mobyus.model.Competence;
import be.mobyus.model.Employee;

@SpringBootApplication
public class SpringMvcDataApplication implements CommandLineRunner {
	@Autowired
    EmployeeRepository empRepo;

    @Autowired
    CompetenceRepository compRepo;
    
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcDataApplication.class, args);
	}
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Competence javascript = new Competence("javascript", "Javascript language skill");
		Competence csharp = new Competence("csharp", "C# language skill");
		Competence java = new Competence("java", "Java language skill");
		Competence spring = new Competence("spring", "Spring framework");

		compRepo.save(javascript);
		compRepo.save(csharp);
		compRepo.save(java);
		compRepo.save(spring);

		List<Employee> employees = new LinkedList<Employee>();
		employees.add(new Employee("John", "Smith", "john.smith@example.com", 
				Arrays.asList(new Competence[] { javascript, csharp })));
		employees.add(new Employee("Mark", "Johnson", "mjohnson@example.com", 
				Arrays.asList(new Competence[] { java, csharp })));
		employees.add(new Employee("Michael", "Williams", "michael.williams@example.com", 
				Arrays.asList(new Competence[] { java, csharp })));
		employees.add(new Employee("Fred", "Miller", "f.miller@example.com", 
				Arrays.asList(new Competence[] { java, spring, javascript })));
		employees.add(new Employee("Bob", "Brown", "brown@example.com", 
				Arrays.asList(new Competence[] { java })));
		empRepo.save(employees);
		
	}
}
