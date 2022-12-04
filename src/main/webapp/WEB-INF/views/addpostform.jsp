<%--
  Created by IntelliJ IDEA.
  User: haeun
  Date: 2022/12/04
  Time: 2:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>New Post</title>
</head>
<body>
<form action="addok" method="post">
    <table id="edit">
        <tr><td>photo</td><td><input type="text" name="photo"></td></tr>
        <tr><td>firstname</td><td><input type="text" name="firstName"></td></tr>
        <tr><td>lastname</td><td><input type="text" name="lastName"></td></tr>
        <tr><td>birthday</td><td><input type="date" name="birthday"></td></tr>
        <tr><td>gender</td><td><input type="text" name="gender"></td></tr>
        <tr><td>email</td><td><input type="text" name="email"></td></tr>
        <tr><td>phone</td><td><input type="text" name="phone"></td></tr>
        <tr><td>information</td><td><textarea cols="50" rows="5" name="information"></textarea></td></tr>
        <tr><td>userType</td><td><input type="text" name="userType"></td></tr>
        <tr><td>account</td><td><input type="text" name="account"></td></tr>
    </table>
    <button type="button" onclick="location.href='list'">list</button>
    <button type="submit">registration</button>
</form>

</body>
</html>
