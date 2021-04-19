package com.example.MainProjectJspandServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerInfo", value = "/CustomerInfo")
public class CustomerInfo extends HttpServlet {
    private CustomerDataBase customerDataBase;

    @Override
    public void init() throws ServletException {
        customerDataBase = new GetDataSource<CustomerDataBase>().getCustomerDataBase();
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
            case "UPDATE":
                updateEmpDesg(request, response);
                break;
        }
    }

    private void loadEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        String desgid = request.getParameter("desgId");
        Customers emp = customerDataBase.getValue(desgid);
        request.setAttribute("st", emp);
        RequestDispatcher rd = request.getRequestDispatcher("/update_customers.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String sname = request.getParameter("sname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String locid = request.getParameter("locid");
        Customers emp = new Customers(id, fname, sname, phone, email, locid);
        customerDataBase.updateValue(emp);
        try {
            request.setAttribute("command", "LIST");
            response.sendRedirect(request.getContextPath() + "/CustomerInfo?command=LIST");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        displayEmpDesg(request,response);/
    }

    private void deleteEmpDesg(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String sname = request.getParameter("sname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String locid = request.getParameter("locid");
        Customers emp = new Customers(id, fname, sname, phone, email, locid);
        customerDataBase.addValueToDB(emp);
        try {
            response.sendRedirect(request.getContextPath() + "/CustomerInfo?command=LIST");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        displayEmpDesg(request,response);
    }

    private void displayEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        List<Customers> empDesignationList = customerDataBase.getValuesFromDb();
        request.setAttribute("list", empDesignationList);

        RequestDispatcher rd = request.getRequestDispatcher("/displaycutomers.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
        /*try {
            response.sendRedirect("/displaycutomers.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
