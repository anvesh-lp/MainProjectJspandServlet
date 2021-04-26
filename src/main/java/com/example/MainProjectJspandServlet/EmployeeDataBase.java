package com.example.MainProjectJspandServlet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataBase {
    private final DataSource dataSource;

    public EmployeeDataBase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Employee> getstudentsFromDB() {
        List<Employee> employees = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from grocerystore.employees");
            while (rs.next()) {
                Employee st = new Employee(rs.getString("Location_id"), rs.getString("Email")
                        , rs.getString("mobile"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getInt("e_id"), rs.getString("dsgn_id"));
                employees.add(st);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }
        return employees;
    }

    private void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void addStudnetToDatabase(Employee student) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlAddquery = "insert into grocerystore.employees " + "(Location_Id,Email,Mobile,First_Name,Last_Name,E_Id,Dsgn_Id)" + "values(?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sqlAddquery);
            stmt.setString(1, student.getLocid());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getMobile());
            stmt.setString(4, student.getFname());
            stmt.setString(5, student.getLaname());
            stmt.setInt(6, student.getEid());
            stmt.setString(7, student.getDsgid());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
    }


    public Employee getEmployee(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        Employee employee = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            String sqlQuery = "select * from grocerystore.employees where E_Id=?";
            stmt = con.prepareStatement(sqlQuery);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                employee = new Employee(rs.getString("Location_id"), rs.getString("Email")
                        , rs.getString("Mobile"), rs.getString("First_Name"), rs.getString("last_Name"),
                        rs.getInt("E_id"), rs.getString("Dsgn_Id"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, rs);
        }
        return employee;
    }


    public void updateStudent(Employee student) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlQuery = "update grocerystore.employees set Location_Id=?,Email=?,Mobile=? ,First_Name=?,Last_Name=?,Dsgn_Id=?, E_Id=? where E_Id=?";
            stmt = con.prepareStatement(sqlQuery);
            stmt.setString(1, student.getLocid());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getMobile());
            stmt.setString(4, student.getFname());
            stmt.setString(5, student.getLaname());
            stmt.setString(6, student.getDsgid());
            stmt.setInt(7, student.getEid());
            stmt.setInt(8, student.getEid());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
    }


    public void deleletStudent(int stid) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlsuery = "delete from studentdatabase.student where id=?";
            stmt = con.prepareStatement(sqlsuery);
            stmt.setInt(1, stid);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
    }

}
