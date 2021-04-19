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
        <a class="active" href="CustomerInfo">View Customers</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div class="container">
    <h1>Update Customer</h1>
</div>
<div class="center">
    <form action="CustomerInfo" method="post">
        <input type="hidden" value="UPDATE" name="command">
        <table class="center">
            <tbody>
            <tr>
                <td>
                    <label>Id</label>
                </td>
                <td><label>
                    <input class="namei" type="number" name="id" value="${st.getId()}" readonly>
                </label></td>
                <%--            <td><label class="namei" type="text" placeholder="Enter Students name" name="id" value="${location.getId()}" readonly></td>--%>
            </tr>
            <tr>
                <td>
                    <label>First Name</label>
                </td>
                <td><input class="namei" type="text" name="fname" value="${st.getFname()}" required="required"></td>
            </tr>

            <tr>
                <td>
                    <label>Second Name</label>
                </td>
                <td><input class="namei" type="text" name="sname" value="${st.getSname()}"
                           required="required"></td>
            </tr>
            <tr>
                <td>
                    <label>Phone</label>
                </td>
                <td><input class="namei" type="text" name="phone" value="${st.getPhone()}"
                           required="required"></td>
            </tr>

            <tr>
                <td>
                    <label>Email</label>
                </td>
                <td><input class="namei" type="text" name="email" value="${st.getEmail()}"
                           required="required"></td>
            </tr>
            <tr>
                <td>
                    <label>Loation Id</label>
                </td>
                <td><input class="namei" type="text" name="locid" value="${st.getLocid()}"
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
