package service;

import exseption.EmployeeAlreadyAddedException;
import exseption.EmployeeNotFoundException;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String,Employee> employees;

    public EmployeeServiceImpl(Map<String, Employee> employees){
        this.employees  = new HashMap<>();

    }

    @Override
    public Employee add(String firstName, String lastName) throws EmployeeAlreadyAddedException{
        Employee employee = new Employee(firstName,lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(),employee);
        return (employee);
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException{
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException{
        Employee employee=new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
