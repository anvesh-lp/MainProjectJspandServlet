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
    <link type="text/css" rel="stylesheet" href="css/side_bar_style.css">
    <link type="text/css" rel="stylesheet" href="css/displaystudentCSS.css">

    <%--        <link type="text/css" rel="stylesheet" href="css/headerstyle.css">--%>

</head>
<body>
<div class="bg">
    <div id="mySidebar" class="sidebar">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
        <a href="${pageContext.request.contextPath}/EmployeeDetails">Student Details</a>
        <a href="${pageContext.request.contextPath}/LocationInfoManagement">Locations</a>
        <a href="${pageContext.request.contextPath}/EmployeeDesignationInfo">Emp. Designations</a>
        <a href="${pageContext.request.contextPath}/CustomerInfo">Customers</a>
        <a href="${pageContext.request.contextPath}/CategorieInfo">Categories</a>
    </div>
    <div id="main">
        <div class="header">

            <%--<div id="head">
                <h2></h2>
            </div>--%>
            <button class="openbtn" onclick="openNav()">☰ Menu</button>
            <a href="" class="logo">UNIVERSITY OF REDLAKUNTA</a>

            <div class="header-right">
                <a class="active" href="home.jsp">Home Page</a>
                <a href="#contact">Locations</a>
                <a href="#about">About</a>
            </div>
        </div>
    </div>
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

