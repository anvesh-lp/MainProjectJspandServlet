package com.example.MainProjectJspandServlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends HttpServlet {

    private EmployeeDataBase studentDataBase;
    private FindId findId;

    @Override
    public void init() throws ServletException {
        //Initializing studentdatabase and getting the server
        Context initCtx = null;
        try {
            initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/MainProjectJspandServlet");
            studentDataBase = new EmployeeDataBase(ds);
            findId = new GetDataSource<FindId>().getFindById();
        } catch (NamingException e) {
            throw new ServletException("Something went wrong in Database");
        }
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
                displayStudents(request, response);
                break;
            case "ADD":
                addStudent(request, response);
                break;
            case "LOAD":
                updateStudent(request, response);
                break;
            case "UPDATE":
                updateStudentInDatabase(request, response);
                break;
            case "DELETE":
                deleteStudenntFromDB(request, response);
                break;
            default:
                displayStudents(request, response);
                break;
        }
//        displayStudents(request,response);
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
                displayStudents(request, response);
                break;
            case "ADD":
                addStudent(request, response);
                break;
            default:
                displayStudents(request, response);
                break;
        }
//        displayStudents(request,response);
    }

    private void deleteStudenntFromDB(HttpServletRequest request, HttpServletResponse response) {
        int stid = Integer.parseInt(request.getParameter("studentId"));
        studentDataBase.deleletStudent(stid);
        try {
            displayStudents(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void updateStudentInDatabase(HttpServletRequest request, HttpServletResponse response) {
        String locid = request.getParameter("locid");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String eid = request.getParameter("eid");
        String dsgid = request.getParameter("dsgid");
        Employee employee = new Employee(locid, email, mobile, fname, lname, Integer.parseInt(eid), dsgid);
        studentDataBase.updateStudent(employee);
        try {
            displayStudents(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("studentId"));
        Employee st = studentDataBase.getEmployee(id);
        request.setAttribute("student", st);
        request.setAttribute("lid", findId.findLocationId());
        request.setAttribute("dsgid", findId.findDesignationId());
        RequestDispatcher rd = request.getRequestDispatcher("/updateStudent.jsp");
        try {
            rd.forward(request, response);
            displayStudents(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void addStudent(HttpServletRequest request, HttpServletResponse response) {
        String locid = request.getParameter("locid");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String eid = request.getParameter("eid");
        String dsgid = request.getParameter("dsgid");
        Employee employee = new Employee(locid, email, mobile, fname, lname, Integer.parseInt(eid), dsgid);
        studentDataBase.addStudnetToDatabase(employee);
        try {
//            displayStudents(request,response);
            response.sendRedirect(request.getContextPath() + "/EmployeeDetails?command=LIST");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> students = studentDataBase.getstudentsFromDB();
        if (students == null) {
            System.out.println("Sutdents list is null");
            PrintWriter out = response.getWriter();
            out.println("Sutdents list is null");
        }
        request.setAttribute("listofstudents", students);
//        RequestDispatcher rd=request.getRequestDispatcher("/displaystudents.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("/menupage.jsp");
        rd.forward(request, response);
    }
}
