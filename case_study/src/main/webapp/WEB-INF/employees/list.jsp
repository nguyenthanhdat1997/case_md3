<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 10/7/2023
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>Employees</title>
</head>
<body>
<table class="table table-dark table-striped">
    <thead>
    <tr>
        <th>Stt</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Date_Of_Birth</th>
        <th>Id_Card</th>
        <th>Phone_Number</th>
        <th>Email</th>
        <th>Address</th>
        <th>Salary</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td><c:out value="${employee.id}"></c:out></td>
            <td><c:out value="${employee.name}"></c:out></td>
            <td><c:out value="${employee.gender}"></c:out></td>
            <td><c:out value="${employee.date_of_birth}"></c:out></td>
            <td><c:out value="${employee.id_card}"></c:out></td>
            <td><c:out value="${employee.phone_number}"></c:out></td>
            <td><c:out value="${employee.email}"></c:out></td>
            <td><c:out value="${employee.address}"></c:out></td>
            <td><c:out value="${employee.salary}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
