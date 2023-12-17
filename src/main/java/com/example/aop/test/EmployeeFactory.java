package com.example.aop.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFactory extends Employee{
    ArrayList<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployee(){

        ProjectEx Delta = new ProjectEx("Delta Model", "Login", "Robert Downey Jr");
        ProjectEx Beta = new ProjectEx("Beta Enhancement", "Authentication", "Chris");
        ProjectEx TwoFactorAuth = new ProjectEx("Two Factor Authentication", "Authentication", "MSD");
        ProjectEx CommonUI = new ProjectEx("Common UI", "UI", "Robert Downey Jr");
        ProjectEx Pegasus = new ProjectEx("Pegasus Model", "Data", "Vikram");
        ProjectEx CustomerOnboarding = new ProjectEx("Customer Onboarding", "Ads", "Vedha");
        ProjectEx Verification = new ProjectEx("Source Verification", "Data", "Pablo");
        ProjectEx RemoveUsers = new ProjectEx("Remove Invalid User", "Proxy", "Jeetu");
        ProjectEx SiteReliability = new ProjectEx("Site Reliability", "Admin", "Zaheer Khan");
        ProjectEx DataTransition = new ProjectEx("Data Transition", "Data", "Atif Aslam");
        ProjectEx TwoPhaseDeployment =new ProjectEx("Two Phase Deployment", "Deployment", "Shaktiman");

        employees.add(new Employee("2020Emp0234", "Bhaskar", "Sharan", 900000, 1, Arrays.asList(Delta, Beta)));
        employees.add(new Employee("2012Emp1923", "ADev", "Sharma", 3500000, 3, Arrays.asList(Pegasus, CustomerOnboarding, Beta, SiteReliability)));
        employees.add(new Employee("2017Emp0721", "Priti", "Kabir", 1800000, 3, Arrays.asList(TwoFactorAuth, Beta, CommonUI)));
        employees.add(new Employee("2017Emp00031", "Chris", "Martin", 2200000, 2, Arrays.asList(Delta, TwoFactorAuth)));
        employees.add(new Employee("2013Emp0872", "Sanjay", "Singhania", 2200000, 3, Arrays.asList(Pegasus, Delta, RemoveUsers, DataTransition)));
        employees.add(new Employee("2022Emp0087", "Babu", "Rao", 900000, 1, Arrays.asList(TwoFactorAuth)));
        employees.add(new Employee("2019Emp0050", "Dev", "Anand", 1300000, 1, Arrays.asList(RemoveUsers, CommonUI)));
        employees.add(new Employee("2023Emp0934", "Shruti", "Sen", 1100000, 1, Arrays.asList(Pegasus)));
        employees.add(new Employee("2023Emp1033", "Akshay", "Kumar", 1200000, 0, Arrays.asList(Delta)));
        employees.add(new Employee("2015Emp0009", "Babu", "Dutt", 2600000, 2, Arrays.asList(Verification, RemoveUsers, TwoPhaseDeployment)));

        return employees;
    }
}
