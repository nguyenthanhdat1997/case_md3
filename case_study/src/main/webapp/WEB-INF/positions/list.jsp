<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 10/8/2023
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Position</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<h1 class="text-center">Product List</h1>
<a href="${pageContext.request.contextPath}/positions?action=create" class="btn btn-info">Create Position</a>
<table class="table table-dark table-striped">
    <thead>
    <tr>
        <th>Stt</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="position" items="${positionList}">
        <tr>
            <td><c:out value="${position.id}"></c:out></td>
            <td><c:out value="${position.name}"></c:out></td>
<%--            <td class="text-center">--%>
<%--                <a href="${pageContext.request.contextPath}/positions?action=edit&id=${position.id}">--%>
<%--                    <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>--%>
<%--                </a>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <a class="btn btn-danger" href="${pageContext.request.contextPath}/positions?action=delete&id=${position.id}">--%>
<%--                    <i class="fa-solid fa-trash-can"></i>--%>
<%--                </a>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
