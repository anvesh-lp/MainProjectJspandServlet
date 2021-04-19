package com.example.MainProjectJspandServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategorieInfo", value = "/CategorieInfo")
public class CategorieInfo extends HttpServlet {
    private CategorieDataBase categorieDataBase;

    @Override
    public void init() throws ServletException {
        categorieDataBase = new GetDataSource<CategorieDataBase>().getCategorieDataBase();
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
        String desgid = request.getParameter("catId");
        Categorie emp = categorieDataBase.getValue(desgid);
        request.setAttribute("st", emp);
        RequestDispatcher rd = request.getRequestDispatcher("/update_categorie.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String fname = request.getParameter("name");
        int sname = Integer.parseInt(request.getParameter("pno"));
        Categorie emp = new Categorie(id, fname, sname);
        categorieDataBase.updateValue(emp);
        try {
            request.setAttribute("command", "LIST");
            response.sendRedirect(request.getContextPath() + "/CategorieInfo?command=LIST");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        displayEmpDesg(request,response);/
    }

    private void deleteEmpDesg(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String fname = request.getParameter("name");
        int sname = Integer.parseInt(request.getParameter("pno"));
        Categorie emp = new Categorie(id, fname, sname);
        categorieDataBase.addValueToDB(emp);
        try {
            response.sendRedirect(request.getContextPath() + "/CategorieInfo?command=LIST");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        displayEmpDesg(request,response);
    }

    private void displayEmpDesg(HttpServletRequest request, HttpServletResponse response) {
        List<Categorie> empDesignationList = categorieDataBase.getValuesFromDb();
        request.setAttribute("list", empDesignationList);
        RequestDispatcher rd = request.getRequestDispatcher("/displaycategories.jsp");
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
