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
        <a class="active" href="displaycategories.jsp">View Customers</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div class="container">
    <h1>Update Customer</h1>
</div>
<div class="center">
    <form action="CategorieInfo" method="post">
        <input type="hidden" value="UPDATE" name="command">
        <table class="center">
            <tbody>
            <tr>
                <td>
                    <label>Categorie Id</label>
                </td>
                <td><label>
                    <input class="namei" type="text" name="id" value="${st.getId()}" readonly>
                </label></td>
                <%--            <td><label class="namei" type="text" placeholder="Enter Students name" name="id" value="${location.getId()}" readonly></td>--%>
            </tr>
            <tr>
                <td>
                    <label>Categorie Name</label>
                </td>
                <td><input class="namei" type="text" name="name" value="${st.getName()}" required="required"></td>
            </tr>

            <tr>
                <td>
                    <label>Product No</label>
                </td>
                <td><input class="namei" type="number" name="pno" value="${st.getPno()}"
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
