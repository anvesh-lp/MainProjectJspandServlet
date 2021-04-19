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
    <a  href="" class="logo">UNIVERSITY OF REDLAKUNTA</a>
    <div class="header-right">
        <a class="active" href="StudentDetails">View Students</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div class="container">
        <h1>Update Student</h1>
</div>
<div class="center">
    <form action="StudentDetails" method="get">
        <input type="hidden" value="UPDATE" name="command">
        <input type="hidden" value="${student.getId()}" name="id">
        <table class="center">
            <tbody>
            <tr>
                <td>
                    <label >Name</label>
                </td>
                <td><input type="text" class="namei" placeholder="Enter Students name" name="name" value="${student.getName()}"></td>
            </tr>
            <tr>
                <td>
                    <label >Percentage</label>
                </td>
                <td><input type="text" class="namei" placeholder="Enter Students Marks" name="percentage" value="${student.getMarks()}"></td>
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