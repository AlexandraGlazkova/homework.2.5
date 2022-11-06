package pro.sky.homework25.service;


import org.springframework.stereotype.Service;
import pro.sky.homework25.exseption.EmployeeAlreadyAddedException;
import pro.sky.homework25.exseption.EmployeeNotFoundException;
import pro.sky.homework25.model.Employee;
import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }


    private String getKey(String firstName, String lastName) {
        return firstName + "|" + lastName;
    }

    @Override
    public Employee add(String firstName, String lastName, int department, double salary) {

        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        String key = firstName + " " + lastName;
        if (employees.containsKey(key)) {
            return employees.remove(key);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден, проверьте правильность ввода данных!");
        }

    }

    @Override
    public Employee find(String firstName, String lastName) {

        String key = firstName + " " + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден, проверьте правильность ввода данных!");
        }
        return employees.get(key);
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
