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
    <%--    <link type="text/css" rel="stylesheet" href="css/headerstyle.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
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
            <a class="active" href="add_student.jsp">Add Student</a>
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
                        <th>Location Id</th>
                        <th>Email</th>
                        <th>Mobile</th>
                        <th>first name</th>
                        <th>last name</th>
                        <th>emp id</th>
                        <th>Desg Id</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <c:forEach var="st" items="${listofstudents}">
                        <tr>
                            <td>${st.getLocid()}</td>
                            <td>${st.getEmail()}</td>
                            <td>${st.getMobile()}</td>
                            <td>${st.getFname()}</td>
                            <td>${st.getLaname()}</td>
                            <td>${st.getEid()}</td>
                            <td>${st.getDsgid()}</td>
                                <%--                        btn btn-labeled btn-success--%>
                            <td id="update">
                                <div class="update"><input type="button" value="Update"
                                                           onclick="window.location.href='EmployeeDetails?command=LOAD&studentId=${st.getEid()}';
return false;" class="updatebt"/></div>
                            </td>
                            <td id="delete">
                                <div class="delete"><input type="button" value="Delete"
                                                           onclick="if(!display()) return false; window.location.href='EmployeeDetails?command=DELETE&studentId=${st.getEid()}';
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

