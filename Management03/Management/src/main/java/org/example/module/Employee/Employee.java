package org.example.module.Employee;

import java.time.LocalDate;
import java.time.LocalTime;

public class Employee {
    private long id;
    private String fullName;
    private String address;
    private String email;
    private String userName;
    private String password;
    private LocalDate createDay;
    private LocalTime updateDay;
    private int status;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", createDay=" + createDay +
                ", updateDay=" + updateDay +
                ", status=" + status +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreateDay() {
        return createDay;
    }

    public void setCreateDay(LocalDate createDay) {
        this.createDay = createDay;
    }

    public LocalTime getUpdateDay() {
        return updateDay;
    }

    public void setUpdateDay(LocalTime updateDay) {
        this.updateDay = updateDay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
