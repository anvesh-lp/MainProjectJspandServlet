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
        <a class="active" href="CustomerInfo">View Customers</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div class="container">
    <h1>Add Designation</h1>
</div>
<div class="center">
    <form action="CustomerInfo" method="post">
        <input type="hidden" value="ADD" name="command">
        <table class="center">
            <tbody>
            <tr>
                <td>
                    <label>Id</label>
                </td>
                <td><label>
                    <input class="namei" type="number" name="id" placeholder="Enter Customer Id" required="required">
                </label></td>
                <%--            <td><label class="namei" type="text" placeholder="Enter Students name" name="id" value="${location.getId()}" readonly></td>--%>
            </tr>
            <tr>
                <td>
                    <label>First Name</label>
                </td>
                <td><input class="namei" type="text" name="fname" placeholder="Enter First Name" required="required">
                </td>
            </tr>

            <tr>
                <td>
                    <label>Second Name</label>
                </td>
                <td><input class="namei" type="text" name="sname" placeholder="Enter Second name"
                           required="required"></td>
            </tr>
            <tr>
                <td>
                    <label>Phone</label>
                </td>
                <td><input class="namei" type="text" name="phone" placeholder="Enter Phone No"
                           required="required"></td>
            </tr>

            <tr>
                <td>
                    <label>Email</label>
                </td>
                <td><input class="namei" type="text" name="email" placeholder="Enter Email Id"
                           required="required"></td>
            </tr>
            <tr>
                <td>
                    <label>Loation Id</label>
                </td>
                <td><input class="namei" type="text" name="locid" placeholder="Enter Location Id"
                           required="required"></td>
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