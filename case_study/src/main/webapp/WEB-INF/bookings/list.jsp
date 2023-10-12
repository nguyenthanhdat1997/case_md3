<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 10/9/2023
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Booking</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<h1 class="text-center">Product List</h1>
<td class="text-center">
    <a href="${pageContext.request.contextPath}/bookings?action=create" class="btn btn-info">Create
        Booking</a>
</td>
<table class="table table-dark table-striped">
    <thead>
    <tr>
        <th>Stt</th>
        <th>Book_Time</th>
        <th>Status</th>
        <th>Customer</th>
        <TH>Employee</TH>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="booking" items="${bookingList}">
        <tr>
            <td><c:out value="${booking.id}"></c:out></td>
            <td><c:out value="${booking.book_time}"></c:out></td>
            <td><c:out value="${booking.status}"></c:out></td>
            <c:forEach var="customer" items="${customerList}">
                <c:if test="${booking.customer_id == customer.id}">
                    <td><c:out value="${customer.name}"></c:out></td>
                </c:if>
            </c:forEach>
            <c:forEach var="employee" items="${employeeList}">
                <c:if test="${booking.employee_id == employee.id}">
                    <td><c:out value="${employee.name}"></c:out></td>
                </c:if>
            </c:forEach>
            <td class="text-center">
                <a href="${pageContext.request.contextPath}/bookings?action=update&id=${booking.getId()}"
                   class="btn btn-info">
                    <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>
                    update
                </a>
            </td>

            <td class="text-center">
                <a href="${pageContext.request.contextPath}/bookings?action=remove&id=${booking.getId()}"
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
