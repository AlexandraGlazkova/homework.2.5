package pro.sky.homework25.service;

import pro.sky.homework25.model.Employee;
import java.util.Collection;


public interface EmployeeService {
    Employee add(String firstName, String lastName, int department, double salary);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();
}