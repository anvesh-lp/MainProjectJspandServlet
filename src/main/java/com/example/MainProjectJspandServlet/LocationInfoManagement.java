package com.example.MainProjectJspandServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LocationInfoManagement", value = "/LocationInfoManagement")
public class LocationInfoManagement extends HttpServlet {
    private LocationDataBase locationDataBase;

    @Override
    public void init() throws ServletException {
        locationDataBase = new GetDataSource<Location>().getLocationDataBase();
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
                displayLocations(request, response);
                break;
            case "ADD":
                addLocation(request, response);
                break;
            case "DELETE":
                deleteLocation(request, response);
                break;
            case "UPDATE":
                updateValueInDB(request, response);
                break;
            case "LOAD":
                loadValueFromDB(request, response);
                break;
        }
    }

    private void updateValueInDB(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        int zipcode = Integer.parseInt(request.getParameter("code"));
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        Location l = new Location(id, zipcode, city, street);
        locationDataBase.updateValue(l);
        displayLocations(request, response);
    }

    private void loadValueFromDB(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("locationID");
        Location lc = locationDataBase.getValue(id);
        System.out.println(lc.getStreet() + "-------" + lc.getZipcode());
        request.setAttribute("location", lc);
        RequestDispatcher rs = request.getRequestDispatcher("/update_location.jsp");
        try {
            rs.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteLocation(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println(id);
        String id = request.getParameter("locationID");
        System.out.println(id);
        locationDataBase.deletevalue(id);
        displayLocations(request, response);
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
                displayLocations(request, response);
                break;
            case "ADD":
                addLocation(request, response);
                break;
            default:
                displayLocations(request, response);
                break;
        }
//        displayStudents(request,response);
    }

    private void addLocation(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        int zipcode = Integer.parseInt(request.getParameter("code"));
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        Location l = new Location(id, zipcode, city, street);
        locationDataBase.addValueToDB(l);
        try {
            response.sendRedirect(request.getContextPath() + "/LocationInfoManagement");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayLocations(HttpServletRequest request, HttpServletResponse response) {
        List<Location> locationList = locationDataBase.getValuesFromDb();
        request.setAttribute("list", locationList);
        RequestDispatcher rd = request.getRequestDispatcher("/displaylocations.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
