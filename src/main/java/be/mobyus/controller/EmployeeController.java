package be.mobyus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import be.mobyus.dao.CompetenceRepository;
import be.mobyus.dao.EmployeeRepository;
import be.mobyus.model.Competence;
import be.mobyus.model.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepository empRepository;

	@Autowired
	CompetenceRepository compRepository;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String employeesIndex(Model model) {
		 return "redirect:/employees";
	}
	@RequestMapping(value="/newemployee",method=RequestMethod.GET)
	public String employeeNew(Model model) {
		 return "newemployee";
	}

	@RequestMapping("/employee/{id}")
	public String employee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", empRepository.findOne(id));
        model.addAttribute("competences", compRepository.findAll());
        return "employee";
	}

    @RequestMapping(value="/employees",method=RequestMethod.GET)
	public String employeesList(Model model) {
        model.addAttribute("employees", empRepository.findAll());
        return "employees";
	}

    @RequestMapping(value="/employees",method=RequestMethod.POST)
	public String employeesAdd(@RequestParam String email, 
						@RequestParam String firstName, @RequestParam String lastName, Model model) {
        Employee newEmployee = new Employee();
        newEmployee.setEmail(email);
        newEmployee.setFirstName(firstName);
        newEmployee.setLastName(lastName);
        empRepository.save(newEmployee);

        model.addAttribute("employee", newEmployee);
        model.addAttribute("competences", compRepository.findAll());
        return "redirect:/employee/" + newEmployee.getId();
	}

    @RequestMapping(value="/employee/{id}/competences", method=RequestMethod.POST)
	public String employeesAddCompetence(@PathVariable Long id, @RequestParam Long competenceId, Model model) {
    	Competence competence = compRepository.findOne(competenceId);
    	Employee employee = empRepository.findOne(id);

    	if (employee != null) {
    		if (!employee.hasCompetence(competence)) {
    			employee.getCompetences().add(competence);
    		}
    		empRepository.save(employee);
            model.addAttribute("employee", empRepository.findOne(id));
            model.addAttribute("competences", compRepository.findAll());
            return "redirect:/employee/" + employee.getId();
    	}

        model.addAttribute("employees", empRepository.findAll());
        return "redirect:/employees";
    }

}