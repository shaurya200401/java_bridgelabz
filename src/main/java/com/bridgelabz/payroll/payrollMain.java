package com.bridgelabz.payroll;

import java.time.LocalDate;

public class payrollMain {

    public static void main(String[] args) throws payrollException {

        payrollDBService service =
                payrollDBService.getInstance();

        System.out.println("---- All Employees ----");
        service.readData().forEach(System.out::println);

        System.out.println("\n---- Update Salary ----");
        service.updateSalaryPrepared("Terisa", 3000000.00);

        System.out.println("\n---- Employees By Date ----");
        service.getEmployeesByDate(
                        LocalDate.of(2018,1,1),
                        LocalDate.now())
                .forEach(System.out::println);

        System.out.println("\n---- Salary Stats ----");
        service.getSalaryStatsByGender();
    }
}