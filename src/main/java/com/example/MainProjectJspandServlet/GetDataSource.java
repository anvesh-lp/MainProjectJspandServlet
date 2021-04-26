package com.example.MainProjectJspandServlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GetDataSource<t> {
    private DataSource dataSource;

    public GetDataSource() {
        Context initCtx = null;
        try {
            initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup("jdbc/MainProjectJspandServlet");
//            EmployeeDataBase db = new EmployeeDataBase(ds);
        } catch (NamingException e) {
//            throw new ServletException("Something went wrong in Database");
            System.out.println("An NamingException in GetDataSourceClass");
        }
    }

    public LocationDataBase getLocationDataBase() {
        return new LocationDataBase(dataSource);

    }

    public EmployeeDesignationDatabase getEmpDataBase() {
        return new EmployeeDesignationDatabase(dataSource);
    }

    public CustomerDataBase getCustomerDataBase() {
        return new CustomerDataBase(dataSource);
    }

    public CategorieDataBase getCategorieDataBase() {
        return new CategorieDataBase(dataSource);
    }

    public FindId getFindById() {
        return new FindId(dataSource);
    }
}
