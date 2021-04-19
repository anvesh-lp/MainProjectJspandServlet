package com.example.MainProjectJspandServlet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataBase {
    private final DataSource dataSource;

    public StudentDataBase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> getstudentsFromDB() {
        List<Student> students = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from studentdatabase.student");
            while (rs.next()) {
                Student st = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("marks"), rs.getString("status"));
                students.add(st);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(conn, stmt, rs);
        }
        return students;
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

    public void addStudnetToDatabase(Student student) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlAddquery = "insert into studentdatabase.student " + "(name,marks,status)" + "values(?,?,?)";
            stmt = con.prepareStatement(sqlAddquery);
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getMarks());
            stmt.setString(3, student.getStatus());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, null);
        }

    }

    public Student getStudent(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        Student student = null;
        ResultSet rs = null;
        try {
            con = dataSource.getConnection();
            String sqlQuery = "select * from studentdatabase.student where id=?";
            stmt = con.prepareStatement(sqlQuery);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("marks"), rs.getString("status"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(con, stmt, rs);
        }
        return student;
    }

    public void updateStudent(Student st) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = dataSource.getConnection();
            String sqlQuery = "update studentdatabase.student set name=?,marks=?,status=? where id=?";
            stmt = con.prepareStatement(sqlQuery);
            stmt.setString(1, st.getName());
            stmt.setInt(2, st.getMarks());
            stmt.setString(3, st.getStatus());
            stmt.setInt(4, st.getId());
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
