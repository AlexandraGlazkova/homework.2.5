package service;

import exseption.EmployeeAlreadyAddedException;
import exseption.EmployeeNotFoundException;
import model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add (String firstName, String lastName) throws EmployeeAlreadyAddedException;
    Employee remove (String firstName, String lastName) throws EmployeeNotFoundException;
    Employee find (String firstName, String lastName) throws EmployeeNotFoundException;

    default Collection<Employee> findAll() {
        return null;
    }
}
