package pro.sky.homework25.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homework25.exseption.InvalidInputException;
import pro.sky.homework25.model.Employee;
import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;
    private final String ERR_EMPL_ALREADY_ADDED = "Сотрудник уже имеется в массиве";
    private final String ERR_EMPL_NOT_FOUND = "Сотрудник не найден";
    private final String ERR_INVALID_NAME = "Неверное имя/фамилия";

    public EmployeeServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        validateInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)) {
            throw new RuntimeException(ERR_EMPL_ALREADY_ADDED);
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        validateInput(firstName, lastName);
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        validateInput(firstName, lastName);
        final Optional<Employee> employee = employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findAny();
        return employee.orElseThrow(() -> new RuntimeException(ERR_EMPL_NOT_FOUND));
    }

    @Override
    public Employee getLowestPaidEmployee(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException(ERR_EMPL_NOT_FOUND));
    }

    @Override
    public Employee getHighestPaidEmployee(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException(ERR_EMPL_NOT_FOUND));
    }

    @Override
    public List<Employee> printEmployeesForDepartment(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> printEmployeesByDepartments() {
        return Collections.unmodifiableList(employees.stream()
                .sorted(Comparator.comparingInt(e -> e.getDepartment()))
                .collect(Collectors.toList()));
    }

    @Override
    public List<Employee> printEmployees() {
        return Collections.unmodifiableList(employees);
    }

    @Override
    public List<Employee> fillEmployeesList() {
        employees.add(new Employee("Maria", "Sharapova", 80_000, 2));
        employees.add(new Employee("Vasya", "Pupkin", 10_000, 1));
        employees.add(new Employee("Oleg", "Ivanov", 20_000, 1));
        employees.add(new Employee("Rafa", "Nadal", 100_000, 2));
        employees.add(new Employee("Roger", "Federer", 120_000, 2));
        employees.add(new Employee("Ivan", "Urgant", 30_000, 1));
        return employees;
    }

    private void validateInput(String firstName, String lastName) {
        if (isAlpha(firstName) && isAlpha(lastName)) {
            throw new InvalidInputException(ERR_INVALID_NAME);
        }

    }
}
