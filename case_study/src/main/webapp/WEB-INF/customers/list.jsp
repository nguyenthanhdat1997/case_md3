<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 10/6/2023
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<td class="text-center">
    <a href="${pageContext.request.contextPath}/customers?action=create" class="btn btn-info">Create
        Customer</a>
</td>
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
        <th>Type customer</th>
        <th>User name</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>

        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.id}"></c:out></td>
                <td><c:out value="${customer.name}"></c:out></td>
                <td><c:out value="${customer.gender}"></c:out></td>
                <td><c:out value="${customer.date_of_birth}"></c:out></td>
                <td><c:out value="${customer.id_card}"></c:out></td>
                <td><c:out value="${customer.phone_number}"></c:out></td>
                <td><c:out value="${customer.email}"></c:out></td>
                <td><c:out value="${customer.address}"></c:out></td>
                <c:forEach var="customerType" items="${customerTypeList}">
                    <c:if test="${customer.customer_type_id == customerType.id}">
                        <td><c:out value="${customerType.name}"></c:out></td>
                    </c:if>
                </c:forEach>
                <c:forEach var="user" items="${userList}">
                    <c:if test="${customer.user_id == user.id}">
                        <td><c:out value="${user.user_name}"></c:out></td>
                    </c:if>
                </c:forEach>

                <td class="text-center">
                    <a href="${pageContext.request.contextPath}/customers?action=update&id=${customer.getId()}"
                       class="btn btn-info">
                        <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>
                        update
                    </a>
                </td>

                <td class="text-center">
                    <a href="${pageContext.request.contextPath}/customers?action=remove&id=${customer.getId()}"
                       class="btn btn-info">
                        <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>
                        delete
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
