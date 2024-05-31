package org.example.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlEmployeeRepository implements EmployeeRepository{

    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/human_resource";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    @Override
    public Employee save(Employee employee) {
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String preparedSql = "insert into employee (full_name, address, email, username, password, create_date, update_date, status) values(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(preparedSql);
            preparedStatement.setString(1, employee.getFullName());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getUserName());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.setString(6, employee.getCreateDay().toString());
            preparedStatement.setString(7, employee.getUpdateDay().toString());
            preparedStatement.setInt(8, employee.getStatus());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error. Please try again.");
            e.printStackTrace();
        }
        return employee;
    }

}
