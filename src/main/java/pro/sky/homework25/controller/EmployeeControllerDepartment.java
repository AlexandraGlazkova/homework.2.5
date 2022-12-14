package pro.sky.homework25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework25.model.Employee;
import pro.sky.homework25.service.DepartmentService;

import java.util.List;


@RestController
@RequestMapping("/employee")

public class EmployeeControllerDepartment {

    private final DepartmentService departmentService;

    public EmployeeControllerDepartment(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/departments/max-salary")
    public Employee maxSalary(@RequestParam(value = "departmentId") int department) {
        return departmentService.findEmployeeWithMaxSalaryFromDepartment(department);
    }
    @GetMapping(path = "/departments/min-salary")
    public Employee minSalary(@RequestParam(value = "departmentId") int department) {
        return departmentService.findEmployeeWithMixSalaryFromDepartment(department);
    }

    @GetMapping(path = "/departments/all")
    public String allEmployeeInDepartment(@RequestParam(value = "departmentId") int department) {

        List<Employee> employees = null;
        try {
            employees = departmentService.findEmployeesFromDepartment(department);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return employees.toString();
    }

    @GetMapping("/departments/all")
    public String getListOfEmployeesByDepartment() {

        return departmentService.findEmployees().toString();
    }
}

