package pro.sky.homework25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework25.model.Employee;
import pro.sky.homework25.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String welcome(){
        return "Добро пожаловать!";
    }

    @GetMapping(path="/complete")
    public boolean completeCollection(){
        return service.completeCollection();
    }

    @GetMapping("/add")
    public boolean addEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return service.add(firstName, lastName);
    }
    @GetMapping("/remove")
    public boolean removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.remove(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping("/findAll")
    public List<Employee> findAllEmployee() {
        return service.findAll();
    }

}