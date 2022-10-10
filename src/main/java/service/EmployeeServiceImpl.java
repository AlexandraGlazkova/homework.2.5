package service;

import exseption.EmployeeAlreadyAddedException;
import exseption.EmployeeNotFoundException;
import model.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees=new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public String welcome() {
        return "Добро пожаловать!";
    }

    @Override
    public boolean add(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник с таким фио уже есть");
        }
        return employees.add(new Employee(firstName, lastName));
    }

    @Override
    public boolean remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return true;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    @Override
    public boolean completeCollection() {
        employees.add(new Employee("Иван", "Иванов"));
        employees.add(new Employee("Денис", "Денисов"));
        employees.add(new Employee("Максим", "Максимов"));
        employees.add(new Employee("Андрей", "Андреев"));
        employees.add(new Employee("Иван", "Андреев"));
        employees.add(new Employee("Денис", "Иванов"));
        employees.add(new Employee("Максим", "Денисов"));
        employees.add(new Employee("Андрей", "Максимов"));
        return true;
    }


    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }


}
