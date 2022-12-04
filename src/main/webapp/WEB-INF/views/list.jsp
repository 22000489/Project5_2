<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haeun
  Date: 2022/12/04
  Time: 2:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<table>
<head>
    <title>게시판</title>
  <script>
    function delete_ok(id){
      var a =confirm("정말로 삭제하겠습니까?");
      if(a) location.href='deleteok/' + id;
    }
  </script>
</head>
<body>
<c:forEach items="${list}" var="u">
  <tr>
    <td>${u.id}</td>
    <td>${u.photo}</td>
    <td>${u.firstName}</td>
    <td>${u.lastName}</td>
    <td>${u.birthday}</td>
    <td>${u.gender}</td>
    <td>${u.email}</td>
    <td>${u.phone}</td>
    <td>${u.information}</td>
    <td>${u.userType}</td>
    <td>${u.account}</td>
    <td>${u.regdate}</td>
    <td><a href="editform/${u.id}">글수정</a></td>
    <td><a href="javascript:delete_ok('${u.id}')">글삭제</a></td>
  </tr>
</c:forEach>
</body>
</table>
<br/><button type="button" onclick="location.href='add'">새 글쓰기</button>
</html>
