<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <link type="text/css" rel="stylesheet" href="css/add_update.css">
    <link type="text/css" rel="stylesheet" href="css/headerstyle.css">
</head>
<body>
<div class="header">
    <a href="" class="logo">UNIVERSITY OF REDLAKUNTA</a>
    <div class="header-right">
        <a class="active" href="EmployeeDetails">View Employees</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div class="container">
    <h1>Update Student</h1>
</div>
<div class="center">
    <form action="EmployeeDetails" method="get">
        <input type="hidden" value="UPDATE" name="command">
        <input type="hidden" value="${student.getEid()}" name="id">
        <table class="center">
            <tbody>
            <tr>
                <td>
                    <label>Location Id</label>
                </td>
                <td>
                    <select name="locid" class="namei">
                        <option value="${student.getLocid()}">${student.getLocid()}</option>
                        <c:forEach items="${lid}" var="category">
                            <option value="${category}">${category}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Email</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter Students name" name="email" required="required"
                           value="${student.getEmail()}">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Mobile</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter Students name" name="mobile" required="required"
                           value="${student.getMobile()}">
                </td>
            </tr>
            <tr>
                <td>
                    <label>First Name</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter Students name" name="fname" required="required"
                           value="${student.getFname()}">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Last Name</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter Students name" name="lname" required="required"
                           value="${student.getLaname()}">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Emp Id</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter Students name" name="eid" required="required"
                           value="${student.getEid()}" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    <label>desg Id</label>
                </td>
                <td>
                    <select name="dsgid" class="namei">
                        <option value="${student.getDsgid()}">${student.getDsgid()}</option>
                        <c:forEach items="${dsgid}" var="category">
                            <option value="${category}">${category}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input class="submitc" type="submit" value="Save"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>