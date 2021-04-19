package com.example.MainProjectJspandServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeDesignationInfo", value = "/EmployeeDesignationInfo")
public class EmployeeDesignationInfo extends HttpServlet {
    private EmployeeDesignationDatabase empDataBase;

    @Override
    public void init() throws ServletException {
        empDataBase = new GetDataSource<EmpDesignation>().getEmpDataBase();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plane");
        String command = request.getParameter("command");
        System.out.println(command);
        if (command == null) {
            command = "LIST";
        }
        switch (command) {
            case "LIST":
                displayEmpDesg(request, response);
                break;
            case "ADD":
                addEmpDesg(request, response);
                break;
            case "DELETE":
                deleteEmpDesg(request, response);
                break;
            case "UPDATE":
                updateEmpDesg(request, response);
                break;
            case "LOAD":
                loadEmpDesg(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plane");
        String command = request.getParameter("command");
        System.out.println(command);
        if (command == null) {
            command = "LIST";
        }
        switch (command) {
            case "LIST":
                displayEmpDesg(request, response);
                break;
            case "ADD":
                addEmpDesg(request, response);
                break;
        }
    }

    private void loadEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        String desgid = request.getParameter("desgId");
        EmpDesignation emp = empDataBase.getValue(desgid);
        request.setAttribute("designation", emp);
        RequestDispatcher rd = request.getRequestDispatcher("/update_designation.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String desg = request.getParameter("desg");
        int salary = Integer.parseInt(request.getParameter("salary"));
        EmpDesignation emp = new EmpDesignation(id, desg, salary);
        empDataBase.updateValue(emp);
        displayEmpDesg(request, response);
    }

    private void deleteEmpDesg(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String desg = request.getParameter("desg");
        int salary = Integer.parseInt(request.getParameter("salary"));
        EmpDesignation emp = new EmpDesignation(id, desg, salary);
        empDataBase.addValueToDB(emp);
        displayEmpDesg(request, response);
    }

    private void displayEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        List<EmpDesignation> empDesignationList = empDataBase.getValuesFromDb();
        request.setAttribute("list", empDesignationList);
        RequestDispatcher rd = request.getRequestDispatcher("/emp_desg_list.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
