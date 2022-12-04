<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="com.example.board.BoardDAO, com.example.board.BoardVO" %>
<%--
  Created by IntelliJ IDEA.
  User: haeun
  Date: 2022/12/04
  Time: 2:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edit Post</title>
</head>
<body>
<form:form modelAttribute="boardVO" method="POST" action="../editok">
    <form:hidden path="id" />
    <table id="edit">
        <tr><td>photo</td><td><form:input path="photo"/></td></tr>
        <tr><td>firstname</td><td><form:input path="firstName"/></td></tr>
        <tr><td>lastname</td><td><form:input path="lastName"/></td></tr>
        <tr><td>birthday</td><td><form:input path="birthday"/></td></tr>
        <tr><td>gender</td><td><form:input path="gender"/></td></tr>
        <tr><td>email</td><td><form:input path="email"/></td></tr>
        <tr><td>phone</td><td><form:input path="phone"/></td></tr>
        <tr><td>information</td><td><form:textarea cols="50" rows="5" path="information"/></td></tr>
        <tr><td>userType</td><td><form:input path="userType"/></td></tr>
        <tr><td>account</td><td><form:input path="account"/></td></tr>
    </table>
    <input type="submit" value="edit"/>
    <input type="button" value="cancel" onclick="history.back()"/>
</form:form>
</body>
</html>
