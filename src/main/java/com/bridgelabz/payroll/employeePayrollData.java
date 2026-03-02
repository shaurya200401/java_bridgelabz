package com.bridgelabz.payroll;

import java.time.LocalDate;

public class employeePayrollData {

    private int id;
    private String name;
    private double salary;
    private LocalDate startDate;
    private String gender;

    public employeePayrollData(int id, String name, double salary,
                               LocalDate startDate, String gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getGender() {
        return gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + salary + " | "
                + startDate + " | " + gender;
    }
}