<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 10/11/2023
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="col-2"></div>
    <div class="col-8">
        <form method="post" class="form-control m-3">
            <div class="form-group" hidden>
                <label class="h6">Booking:</label>
                <div class="input-group">
                    <input type="text" class="form-control" name="id" value="<c:out value="${booking.id}"/>">
                    <span class="input-group-text"> <i class="fa-solid fa-person-circle-question"></i></span>
                </div>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="book_time" type="datetime-local" name="book_time"
                       value="${bookingList.getBook_time()}">
                <label for="book_time">Book Time</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="status" type="text" name="status" value="${bookingList.getStatus()}">
                <label for="status">Status</label>
            </div>

            <div class="form-floating mb-3">

                <select name="customer_id" class="form-select" aria-label="Default select example"
                        style="padding: 0 20px">
                    <c:forEach var="customer" items="${customerList}">
                        <option value="${customer.id}">
                                ${customer.name}
                        </option>
                    </c:forEach>

                </select>
            </div>
            <div class="form-floating mb-3">
                <select name="employee_id" class="form-select" aria-label="Default select example"
                        style="padding: 0 20px">
                    <c:forEach var="employee" items="${employeeList}">
                        <option value="${employee.id}">
                                ${employee.name}
                        </option>
                    </c:forEach>
                </select>

            </div>
            <div class="mt-3 text-center">
                <button type="submit" value="update" class="btn btn-info btn-sm border border-2 border-success">
                    -- Save <i class="fa-solid fa-floppy-disk"></i> --
                </button>
            </div>
        </form>
    </div>
    <div class="col-2"></div>
</div>
</body>
</html>
