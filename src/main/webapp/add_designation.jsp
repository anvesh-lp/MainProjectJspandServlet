<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link type="text/css" rel="stylesheet" href="css/add_update.css">
    <%--    <link type="text/css" rel="stylesheet" href="css/headerstyle.css">--%>
</head>
<body>
<div class="header">
    <a href="home.jsp" class="logo">UNIVERSITY OF REDLAKUNTA</a>
    <div class="header-right">
        <a class="active" href="EmployeeDesignationInfo">View Designations</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div class="container">
    <h1>Add Designation</h1>
</div>
<div class="center">
    <form action="EmployeeDesignationInfo" method="post">
        <input type="hidden" value="ADD" name="command">
        <table class="center">
            <tbody>
            <tr>
                <td>
                    <label>Id</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter Designation id" name="id" required="required">
                </td>
            </tr>

            <td>
                <label>Designation</label>
            </td>
            <td><input class="namei" type="text" placeholder="Enter Designation" name="desg" required="required"></td>
            </tr>

            <td>
                <label>Salary</label>
            </td>
            <td><input class="namei" type="number" placeholder="Enter Salary" name="salary" required="required"></td>
            </tr>
            <%--<tr>
                <td>
                    <label >Street</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter Students Marks" name="street" required="required"></td>
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