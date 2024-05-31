package org.example;

import org.example.module.Employee.EmployeeController;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        System.out.println("hello everyone");
        employeeController.createEmployee();
    }
}