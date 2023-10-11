<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 10/8/2023
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<table class="table table-dark table-striped">
    <thead>
    <tr>
        <th>Stt</th>
        <th>UserName</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.user_name}"></c:out></td>
            <td><c:out value="${user.password}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
