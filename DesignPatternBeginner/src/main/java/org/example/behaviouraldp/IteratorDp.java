package org.example.behaviouraldp;

import org.example.behaviouraldp.iterator.Company;
import org.example.behaviouraldp.iterator.Employee;
import org.example.behaviouraldp.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

public class IteratorDp {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("Bob", 60000));
        employees.add(new Employee("Charlie", 70000));

        Company company = new Company(employees);
        Iterator<Employee> iterator = company.createIterator();

        double totalSalary = 0;
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println("Employee: " + employee.getName() + ", Salary: " + employee.getSalary());
            totalSalary += employee.getSalary();
        }

        System.out.println("Total salary: " + totalSalary);
    }
}
