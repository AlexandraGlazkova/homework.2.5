package pro.sky.homework25.service;

import pro.sky.homework25.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalaryFromDepartment(int department);
    Employee findEmployeeWithMixSalaryFromDepartment(int department);
    List<Employee> findEmployeesFromDepartment(int department);
    Map<Integer,List<Employee>> findEmployees();
}
