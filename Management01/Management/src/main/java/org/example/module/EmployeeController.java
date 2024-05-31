package org.example.module;

import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeController {
    EmployeeRepository employeeRepository = new MySqlEmployeeRepository();
    Scanner scanner = new Scanner(System.in);

    public void createEmployee() {
        MySqlEmployeeRepository employeeRepository = new MySqlEmployeeRepository();
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.println("Enter your name:");
        employee.setFullName(scanner.nextLine());

        System.out.println("Enter your address:");
        employee.setAddress(scanner.nextLine());

        System.out.println("Enter your email:");
        employee.setEmail(scanner.nextLine());

        System.out.println("Enter your password:");
        employee.setPassword(scanner.nextLine());

        System.out.println("Enter your day create:");
        employee.setCreateDay(LocalDate.parse(scanner.nextLine()));

        System.out.println("Enter your day update:");
        employee.setCreateDay(LocalDate.parse(scanner.nextLine()));

        System.out.println("Enter your status:");
        employee.setStatus(scanner.nextInt());

        System.out.println("Employee information.");
        System.out.println(employee);
        System.out.println("Are you sure wanna save this employee (y/n):");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("y")){
            employeeRepository.save(employee);
        }
    }
}
