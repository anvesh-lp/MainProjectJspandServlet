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
    <a href="" class="logo">UNIVERSITY OF REDLAKUNTA</a>
    <div class="header-right">
        <a class="active" href="${pageContext.request.contextPath}/CategorieInfo">View Categories</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div class="container">
    <h1>Add Categorie</h1>
</div>
<div class="center">
    <form action="CategorieInfo" method="post">
        <input type="hidden" value="ADD" name="command">
        <table class="center">
            <tbody>
            <tr>
                <td>
                    <label>Id</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter Categorie Id" name="id" required="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Categorie Name</label>
                </td>
                <td><input class="namei" type="text" placeholder="Enter Categorie name" name="name" required="required">
                </td>
            </tr>

            <tr>
                <td>
                    <label>Product No</label>
                </td>
                <td><input class="namei" type="number" placeholder="Enter Product no" name="pno" required="required">
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