package com.example.MainProjectJspandServlet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataBase implements DataBase<Customers> {
    private final DataSource dataSource;
    private final String GETVALUES = "Select * from grocerystore.customers";

    public CustomerDataBase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Customers> getValuesFromDb() {
        List<Customers> ls = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            stmt = con.prepareStatement(GETVALUES);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Customers l = new Customers(rs.getInt("Cust_ID")
                        , rs.getString("First_name"), rs.getString("Last_name"),
                        rs.getString("Phone"), rs.getString("Email"),
                        rs.getString("Location_Id"));
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
    public void addValueToDB(Customers value) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlAddquery = "insert into grocerystore.customers " + "(Cust_ID,First_name,Last_name,Phone,Email,Location_Id)" + "values(?,?,?,?,?,?)";
            stmt = con.prepareStatement(sqlAddquery);
            stmt.setInt(1, value.getId());
            stmt.setString(2, value.getFname());
            stmt.setString(3, value.getSname());
            stmt.setString(4, value.getPhone());
            stmt.setString(5, value.getEmail());
            stmt.setString(6, value.getLocid());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
    }

    @Override
    public Customers getValue(String value) {
        Connection con = null;
        PreparedStatement stmt = null;
        Customers customers = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            int id = Integer.parseInt(value);
            System.out.println(value);
            String sqlQuery = "select * from grocerystore.customers where Cust_ID=?";
            stmt = con.prepareStatement(sqlQuery);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            System.out.println("IN DataBase");
            while (rs.next()) {
                System.out.println("Inside Loop");
                customers = new Customers(rs.getInt("Cust_ID")
                        , rs.getString("First_name"), rs.getString("Last_name"),
                        rs.getString("Phone"), rs.getString("Email"),
                        rs.getString("Location_Id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, rs);
        }
        return customers;
    }

    @Override
    public void updateValue(Customers value) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
//            int id=Integer.parseInt(value);
            String sqlQuery = "update grocerystore.customers set Cust_ID=?,First_name=?,Last_name=?,Phone=?,Email=?,Location_Id=? where Cust_ID=?";
            System.out.println("updating database");
            stmt = con.prepareStatement(sqlQuery);
            stmt.setInt(1, value.getId());
            stmt.setString(2, value.getFname());
            stmt.setString(3, value.getSname());
            stmt.setString(4, value.getPhone());
            stmt.setString(5, value.getEmail());
            stmt.setString(6, value.getLocid());
            stmt.setInt(7, value.getId());
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
            int id = Integer.parseInt(value);
            con = dataSource.getConnection();
            String sqlsuery = "delete from grocerystore.customers where Cust_ID = ?";
            stmt = con.prepareStatement(sqlsuery);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
    }
}
