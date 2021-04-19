package com.example.MainProjectJspandServlet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDesignationDatabase implements DataBase<EmpDesignation> {
    private final DataSource dataSource;
    private final String GETVALUES = "Select * from grocerystore.designation";

    public EmployeeDesignationDatabase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<EmpDesignation> getValuesFromDb() {
        List<EmpDesignation> ls = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            stmt = con.prepareStatement(GETVALUES);
            rs = stmt.executeQuery();
            while (rs.next()) {
                EmpDesignation l = new EmpDesignation(rs.getString("Dsgn_Id")
                        , rs.getString("Designation"), rs.getInt("Salary"));
                ls.add(l);
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
        return ls;
    }

    @Override
    public void close(Connection conn, Statement stmt, ResultSet rs) {
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


    @Override
    public void addValueToDB(EmpDesignation value) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlAddquery = "insert into grocerystore.designation " + "(Dsgn_Id,Designation,Salary)" + "values(?,?,?)";
            stmt = con.prepareStatement(sqlAddquery);
            stmt.setString(1, value.getId());
            stmt.setString(2, value.getDesignation());
            stmt.setInt(3, value.getSalary());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
    }

    @Override
    public EmpDesignation getValue(String value) {
        Connection con = null;
        PreparedStatement stmt = null;
        EmpDesignation empDesignation = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            System.out.println(value);
            String sqlQuery = "select * from grocerystore.designation where Dsgn_Id=?";
            stmt = con.prepareStatement(sqlQuery);
            stmt.setString(1, value);
            rs = stmt.executeQuery();
            System.out.println("IN DataBase");

            while (rs.next()) {
                System.out.println("Inside Loop");
                empDesignation = new EmpDesignation(rs.getString("Dsgn_Id")
                        , rs.getString("Designation"), rs.getInt("Salary"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, rs);
        }
        return empDesignation;
    }


    @Override
    public void updateValue(EmpDesignation value) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlQuery = "update grocerystore.designation set Dsgn_Id=?,Designation=?,Salary=? where Dsgn_Id=?";
            System.out.println("updating database");
            stmt = con.prepareStatement(sqlQuery);
            stmt.setString(1, value.getId());
            stmt.setString(2, value.getDesignation());
            stmt.setInt(3, value.getSalary());
            stmt.setString(4, value.getId());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
    }

    @Override
    public void deletevalue(String value) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlsuery = "delete from grocerystore.location where Location_Id = ?";
            stmt = con.prepareStatement(sqlsuery);
            stmt.setString(1, value);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
    }
}
