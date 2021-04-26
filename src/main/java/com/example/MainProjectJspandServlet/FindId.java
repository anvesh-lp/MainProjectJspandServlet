package com.example.MainProjectJspandServlet;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class FindId {
    private DataSource dataSource;

    public FindId(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Set<String> findLocationId() {
        Set<String> lid = new HashSet<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from grocerystore.employees");
            while (rs.next()) {
                lid.add(rs.getString("location_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }
        return lid;
    }

    public Set<String> findDesignationId() {
        Set<String> lid = new HashSet<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from grocerystore.designation");
            while (rs.next()) {
                lid.add(rs.getString("Dsgn_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }
        return lid;
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
}
