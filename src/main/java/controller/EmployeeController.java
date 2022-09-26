package controller;

import exseption.EmployeeAlreadyAddedException;
import exseption.EmployeeNotFoundException;
import model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeAlreadyAddedException {
        return service.add(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeNotFoundException {
        return service.remove(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeNotFoundException {
        return service.find(firstName, lastName);
    }
    @GetMapping("/findAll")
    public Collection<Employee> findAll(){
        return service.findAll();
    }
}
