package org.example;

import org.example.module.EmployeeController;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        System.out.println("hello");
        employeeController.createEmployee();
    }
}