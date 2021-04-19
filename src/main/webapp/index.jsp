<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link type="text/css" rel="stylesheet" href="css/headerstyle.css">
    <link type="text/css" rel="stylesheet" href="css/loginpage.css">
</head>
<body>
<div class="header">
    <a href="" class="logo">University of Redlakunta</a>
    <div class="header-right">
        <a class="active" href="">Sign In</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div class="container">
    <h1>Login</h1>
</div>
<%--<h1><%= "Hello World!" %>--%>
<div class="divtable">
    <form action="home.jsp" method="post">
        <input type="hidden" value="ADD" name="command">
        <table class="center">
            <tbody>
            <tr>
                <td>
                    <label>UserName</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter UserName" name="name" required="required"></td>
            </tr>
            <tr>
                <td>
                    <label>Password</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter Password" name="percentage" required="required">
                </td>
            </tr>
            <tr>
                <td colspan="2"><input class="submitc" type="submit" value="LOGIN"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>