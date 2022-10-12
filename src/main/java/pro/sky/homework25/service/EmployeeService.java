package pro.sky.homework25.service;

import pro.sky.homework25.model.Employee;

import java.util.List;

public interface EmployeeService {
    public boolean add(String firstName, String lastName);

    public boolean remove(String firstName, String lastName);

    public Employee find(String firstName, String lastName);

    public boolean completeCollection();

    public List<Employee> findAll();

    String welcome();
}
