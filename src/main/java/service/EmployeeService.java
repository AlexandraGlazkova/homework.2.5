package service;

import model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public boolean add(String firstName, String lastName);

    public boolean remove(String firstName, String lastName);

    public Employee find(String firstName, String lastName);

    public boolean completeCollection();

    public List<Employee> findAll();

    String welcome();
}