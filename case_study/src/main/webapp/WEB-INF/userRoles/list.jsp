<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 10/9/2023
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
        <th>Role</th>
        <th>User</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="userRole" items="${userRoleList}">
        <c:forEach var="user" items="${userList}">
            <c:if test="${userRole.user_id == user.id}">
                <td><c:out value="${user.user_name}"></c:out></td>
            </c:if>
        </c:forEach>
    </c:forEach>
    <c:forEach var="userRole" items="${userRoleList}">
        <c:forEach var="role" items="${roleList}">
            <c:if test="${userRole.role_id == role.id}">
                <td><c:out value="${role.name}"></c:out></td>
            </c:if>
        </c:forEach>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
