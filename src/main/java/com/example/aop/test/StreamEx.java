package com.example.aop.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        employeeList.stream().map(Employee::getProjects).flatMap(Collection::stream).distinct().forEach(p -> {
            System.out.println(p.getName());
        });

        employeeList.stream().filter(e -> e.getFirstName().startsWith("A")).forEach(System.out::println);

        employeeList.stream().sorted(Comparator.comparing(Employee::getFirstName));
    }
}
