<%--
  Created by IntelliJ IDEA.
  User: naga.a.kunuguntla
  Date: 4/15/2021
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%-------------------------------------------------------------------------------------------------------------------------------------%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List Of Students</title>
    <script>
         <!--
            function display() {
               if(!confirm("Do U wanna delete the student from Redlakunta University?")){
               return false;
               }
               return true;
            }
         //-->



    </script>
    <link type="text/css" rel="stylesheet" href="css/displaystudentCSS.css">
    <link type="text/css" rel="stylesheet" href="css/side_bar_style.css">
</head>
<body>
<div id="mySidebar" class="sidebar">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
    <a href="${pageContext.request.contextPath}/EmployeeDetails">Employees</a>
    <a href="${pageContext.request.contextPath}/LocationInfoManagement">Locations</a>
    <a href="${pageContext.request.contextPath}/EmployeeDesignationInfo">Emp. Designations</a>
    <a href="${pageContext.request.contextPath}/CustomerInfo">Customers</a>
    <a href="${pageContext.request.contextPath}/CategorieInfo">Categories</a>
</div>
<div id="main">
    <button class="openbtn" onclick="openNav()">☰ Open Sidebar</button>
    <div id="head">
        <h2></h2>
    </div>
    <div class="header">
        <a href="home.jsp" class="logo">UNIVERSITY OF REDLAKUNTA</a>
        <div class="header-right">
            <a class="active" href="add_customer.jsp">Add Customer</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
        </div>
    </div>
    <div class="but">
        <%--    <input type="button" value="Add Student" onclick="window.location.href='add_student.jsp';--%>
        <%--return false;" class="bt"/>--%>
    </div>
    <div class="center">
        <div id="content">
            <div class="bg">
                <table class="center">
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Second Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Location Id</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <c:forEach var="st" items="${list}">
                        <tr>
                            <td>${st.getId()}</td>
                            <td>${st.getFname()}</td>
                            <td>${st.getSname()}</td>
                            <td>${st.getPhone()}</td>
                            <td>${st.getEmail()}</td>
                            <td>${st.getLocid()}</td>
                                <%--                            <td>${st.getStreet()}</td>--%>
                                <%--                        btn btn-labeled btn-success--%>
                            <td id="update">
                                <div class="update"><input type="button" value="Update"
                                                           onclick="window.location.href='CustomerInfo?command=LOAD&desgId=${st.getId()}';
return false;" class="updatebt"/></div>
                            </td>
                            <td id="delete">
                                <div class="delete"><input type="button" value="Delete"
                                                           onclick="if(!display()) return false; window.location.href='CustomerInfo?command=DELETE&desgId=${st.getId()}';
                                                       return false;"
                                                           class="deletebt"/>
                                </div>
                            </td>
                                <%--        onclick="do(); window.location.href='EmployeeDetails?command=DELETE&studentId=${st.getId()}'; return false;"--%>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <%--    <h2>Collapsed Sidebar</h2>--%>
    <%--    <p>Click on the hamburger menu/bar icon to open the sidebar, and push this content to the right.</p>--%>
</div>

<script>
function openNav() {
  document.getElementById("mySidebar").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
  document.getElementById("mySidebar").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}

</script>

</body>
</html>

