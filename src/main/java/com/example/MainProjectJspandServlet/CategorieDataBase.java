package com.example.MainProjectJspandServlet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDataBase implements DataBase<Categorie> {
    private final DataSource dataSource;
    private final String GETVALUES = "Select * from grocerystore.categories";

    public CategorieDataBase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Categorie> getValuesFromDb() {
        List<Categorie> ls = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            stmt = con.prepareStatement(GETVALUES);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Categorie l = new Categorie(rs.getString("Category_Id"), rs.getString("Category_Name"), rs.getInt("Product_No"));
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
    public void addValueToDB(Categorie value) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlAddquery = "insert into grocerystore.categories " + "(Category_Id, Category_Name, Product_No)" + "values(?,?,?)";
            stmt = con.prepareStatement(sqlAddquery);
            stmt.setString(1, value.getId());
            stmt.setString(2, value.getName());
            stmt.setInt(3, value.getPno());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
    }

    @Override
    public Categorie getValue(String value) {
        Connection con = null;
        PreparedStatement stmt = null;
        Categorie categorie = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
//            int id=Integer.parseInt(value);
            System.out.println(value);
            String sqlQuery = "select * from grocerystore.categories where Category_Id=?";
            stmt = con.prepareStatement(sqlQuery);
            stmt.setString(1, value);
            rs = stmt.executeQuery();
            System.out.println("IN DataBase");
            while (rs.next()) {
                System.out.println("Inside Loop");
                categorie = new Categorie(rs.getString("Category_Id"), rs.getString("Category_Name"), rs.getInt("Product_No"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, rs);
        }
        return categorie;
    }

    @Override
    public void updateValue(Categorie value) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
//            int id=Integer.parseInt(value);
            String sqlQuery = "update grocerystore.categories set Category_Id=?,Category_Name=?,Product_No=? where Category_Id=?";
            System.out.println("updating database");
            stmt = con.prepareStatement(sqlQuery);
            stmt.setString(1, value.getId());
            stmt.setString(2, value.getName());
            stmt.setInt(3, value.getPno());
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
//            int id=Integer.parseInt(value);
            con = dataSource.getConnection();
            String sqlsuery = "delete from grocerystore.categories where Category_Id = ?";
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
