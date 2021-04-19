<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link type="text/css" rel="stylesheet" href="css/add_update.css">
    <link type="text/css" rel="stylesheet" href="css/headerstyle.css">
</head>
<body>
<div class="header">
    <a href="" class="logo">UNIVERSITY OF REDLAKUNTA</a>
    <div class="header-right">
        <a class="active" href="StudentDetails">View Designations</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div class="container">
    <h1>Update Designation</h1>
</div>
<div class="center">
    <form action="EmployeeDesignationInfo" method="get">
        <input type="hidden" value="UPDATE" name="command">
        <table class="center">
            <tbody>
            <tr>
                <td>
                    <label>Id</label>
                </td>
                <td><label>
                    <input class="namei" type="text" name="id" value="${designation.getId()}" readonly>
                </label></td>
                <%--            <td><label class="namei" type="text" placeholder="Enter Students name" name="id" value="${location.getId()}" readonly></td>--%>
            </tr>

            <td>
                <label>ZipCode</label>
            </td>
            <td><input class="namei" type="text" name="desg" value="${designation.getDesignation()}"
                       required="required"></td>
            </tr>

            <td>
                <label>City</label>
            </td>
            <td><input class="namei" type="salary" name="salary" value="${designation.getSalary()}" required="required">
            </td>
            </tr>
            <%--<tr>
                <td>
                    <label >Street</label>
                </td>
                <td><input class="namei" type="text"  name="street" value="${location.getStreet()}" required="required"></td>
            </tr>--%>
            <tr>
                <td colspan="2"><input class="submitc" type="submit" value="Save"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
