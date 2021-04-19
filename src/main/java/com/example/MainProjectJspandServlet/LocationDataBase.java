package com.example.MainProjectJspandServlet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDataBase implements DataBase<Location> {
    private final DataSource dataSource;
    private final String GETVALUES = "Select * from grocerystore.location";

    public LocationDataBase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Location> getValuesFromDb() {
        List<Location> ls = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            stmt = con.prepareStatement(GETVALUES);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Location l = new Location(rs.getString("Location_Id")
                        , rs.getInt("Zipcode"), rs.getString("City"), rs.getString("Street"));
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
    public void addValueToDB(Location value) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlAddquery = "insert into grocerystore.location " + "(Location_Id,Zipcode,City,Street)" + "values(?,?,?,?)";
            stmt = con.prepareStatement(sqlAddquery);
            stmt.setString(1, value.getId());
            stmt.setInt(2, value.getZipcode());
            stmt.setString(3, value.getCity());
            stmt.setString(4, value.getCity());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }
    }

    @Override
    public Location getValue(String value) {
        Connection con = null;
        PreparedStatement stmt = null;
        Location location = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            System.out.println(value);
            String sqlQuery = "select * from grocerystore.location where Location_Id=?";
            stmt = con.prepareStatement(sqlQuery);
            stmt.setString(1, value);
            rs = stmt.executeQuery();
            System.out.println("IN DataBase");

            while (rs.next()) {
                System.out.println("Inside Loop");
                location = new Location(rs.getString("Location_Id"), rs.getInt("Zipcode"), rs.getString("City"), rs.getString("Street"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, rs);
        }
        return location;
    }

    @Override
    public void updateValue(Location value) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlQuery = "update grocerystore.location set Location_Id=?,Zipcode=?,City=?,Street=? where Location_Id=?";
            System.out.println("updating database");
            stmt = con.prepareStatement(sqlQuery);
            stmt.setString(1, value.getId());
            stmt.setInt(2, value.getZipcode());
            stmt.setString(3, value.getCity());
            stmt.setString(4, value.getStreet());
            stmt.setString(5, value.getId());
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
