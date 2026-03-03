package com.bridgelabz.payroll;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class payrollDBService {

    private static payrollDBService instance;

    private final String jdbcURL =
            "jdbc:mysql://localhost:3306/payroll_service?useSSL=false&allowPublicKeyRetrieval=true";
    private final String username = "root";
    private final String password = "password";

    private payrollDBService() {}

    public static payrollDBService getInstance() {
        if (instance == null)
            instance = new payrollDBService();
        return instance;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }

    // ================= UC2 =================
    public List<employeePayrollData> readData() throws payrollException {

        List<employeePayrollData> list = new ArrayList<>();
        String sql = "SELECT * FROM employee_payroll";

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new employeePayrollData(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getString("gender")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new payrollException("Error reading payroll data");
        }

        return list;
    }

    // ================= UC3 =================
    public void updateSalary(String name, double salary)
            throws payrollException {

        String sql =
                "UPDATE employee_payroll SET salary = "
                        + salary + " WHERE name = '" + name + "'";

        try (Connection con = getConnection();
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new payrollException("Error updating salary");
        }
    }

    // ================= UC4 (PreparedStatement) =================
    public void updateSalaryPrepared(String name, double salary)
            throws payrollException {

        String sql =
                "UPDATE employee_payroll SET salary = ? WHERE name = ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setDouble(1, salary);
            pstmt.setString(2, name);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new payrollException("Error updating salary (Prepared)");
        }
    }

    // ================= UC5 =================
    public List<employeePayrollData> getEmployeesByDate(
            LocalDate start, LocalDate end)
            throws payrollException {

        List<employeePayrollData> list = new ArrayList<>();
        String sql =
                "SELECT * FROM employee_payroll WHERE start_date BETWEEN ? AND ?";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setDate(1, Date.valueOf(start));
            pstmt.setDate(2, Date.valueOf(end));

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new employeePayrollData(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getString("gender")
                ));
            }

        } catch (SQLException e) {
            throw new payrollException("Error retrieving by date");
        }

        return list;
    }

    // ================= UC6 =================
    public Map<String, salaryStats> getSalaryStatsByGender()
            throws payrollException {

        Map<String, salaryStats> statsMap = new HashMap<>();

        String sql = """
            SELECT gender,
                   SUM(salary) AS total,
                   AVG(salary) AS average,
                   MIN(salary) AS minimum,
                   MAX(salary) AS maximum,
                   COUNT(*) AS count
            FROM employee_payroll
            GROUP BY gender
            """;

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String gender = rs.getString("gender");

                salaryStats stats = new salaryStats(
                        rs.getDouble("total"),
                        rs.getDouble("average"),
                        rs.getDouble("minimum"),
                        rs.getDouble("maximum"),
                        rs.getInt("count")
                );

                // Store in Map
                statsMap.put(gender, stats);

                // Print to console
                System.out.println(
                        gender +
                                " | SUM: " + stats.getSum() +
                                " | AVG: " + stats.getAverage() +
                                " | MIN: " + stats.getMin() +
                                " | MAX: " + stats.getMax() +
                                " | COUNT: " + stats.getCount()
                );
            }

        } catch (SQLException e) {
            throw new payrollException("Error retrieving stats");
        }

        return statsMap;
    }
}