<%--
<%@ page import="java.util.List" %>
<%@ page import="com.example.MainProjectJspandServlet.Student" %>&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: naga.a.kunuguntla
  Date: 4/12/2021
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
&lt;%&ndash;    <link type="text/css" rel="stylesheet" href="css/headerstyle.css">&ndash;%&gt;
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
<div id="head">
    <h2></h2>
</div>
<div class="header">
    <a  href="" class="logo">UNIVERSITY OF REDLAKUNTA</a>
    <div class="header-right">
        <a class="active" href="add_student.jsp">Add Student</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div class="but">
&lt;%&ndash;    <input type="button" value="Add Student" onclick="window.location.href='add_student.jsp';&ndash;%&gt;
&lt;%&ndash;return false;" class="bt"/>&ndash;%&gt;
</div>
<div class="center">
    <div id="content">
        <div class="bg">
            <table class="center">
                <tr>
                    <th>Name</th>
                    <th>Score</th>
                    <th>Status</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="st" items="${listofstudents}">
                    <tr>
                        <td>${st.getName()}</td>
                        <td>${st.getMarks()}</td>
                        <td>${st.getStatus()}</td>
&lt;%&ndash;                        btn btn-labeled btn-success&ndash;%&gt;
                        <td id="update">
                            <div class="update"><input type="button" value="Update"
                                                       onclick="window.location.href='StudentDetails?command=LOAD&studentId=${st.getId()}';
return false;" class="updatebt"/></div>
                        </td>
                        <td id="delete">
                            <div class="delete"><input type="button" value="Delete"
                                                       onclick="if(!display()) return false; window.location.href='StudentDetails?command=DELETE&studentId=${st.getId()}';
                                                       return false;"
                                                       class="deletebt"/>
                            </div>
                        </td>
                            &lt;%&ndash;        onclick="do(); window.location.href='StudentDetails?command=DELETE&studentId=${st.getId()}'; return false;"&ndash;%&gt;
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
--%>
