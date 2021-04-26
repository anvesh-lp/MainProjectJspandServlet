<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
</head>
<body>
<div class="container">
    <div class="heading">
        <h1>Add Student</h1>
    </div>
</div>
<div class="center">
    <form action="EmployeeDetails" method="get">
        <input type="hidden" value="DELETE" name="command">
        <input type="hidden" value="${student.getId()}" name="id">
        <table class="center">
            <tbody>
            <tr>
                <td>
                    <label>Name</label>
                </td>
                <td><input type="text" placeholder="Enter Students name" name="name" value="${student.getName()}"></td>
            </tr>
            <tr>
                <td>
                    <label>Percentage</label>
                </td>
                <td><input type="text" placeholder="Enter Students Marks" name="percentage"
                           value="${student.getMarks()}"></td>
            </tr>
            <tr>
                <td>
                    <label></label>
                </td>
                <td><input type="submit" value="Save"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>