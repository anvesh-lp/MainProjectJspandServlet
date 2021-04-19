package com.example.MainProjectJspandServlet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

interface DataBase<t> {
    //    private DataSource dataSource;
    List<t> getValuesFromDb();

    void close(Connection conn, Statement stmt, ResultSet rs);

    void addValueToDB(t value);

    t getValue(String value);

    void updateValue(t value);

    void deletevalue(String value);
}
