package pro.sky.homework25.service;

import org.springframework.stereotype.Service;
import pro.sky.homework25.exseption.EmployeeNotFoundException;
import pro.sky.homework25.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
        return employeeService.findAll().stream()
                .filter((employee -> employee.getDepartment() == department))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMixSalaryFromDepartment(int department) {
        return employeeService.findAll().stream()
                .filter((employee -> employee.getDepartment() == department))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findEmployeesFromDepartment(int department) {
        return employeeService.findAll().stream()
                .filter((employee -> employee.getDepartment() == department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployees() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
