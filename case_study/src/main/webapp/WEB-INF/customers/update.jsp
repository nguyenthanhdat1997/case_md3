<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 10/12/2023
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="col-2"></div>
    <div class="col-8">
        <form method="post" class="form-control m-3">
            <div class="form-group" hidden>
                <label class="h6">Customer:</label>
                <div class="input-group">
                    <input type="text" class="form-control" name="id" value="<c:out value="${customer.id}"/>" >
                    <span class="input-group-text"> <i class="fa-solid fa-person-circle-question"></i></span>
                </div>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="name" type="text" name="name" value="${customerList.getName()}">
                <label for="name">FullName</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="gender" type="text" name="gender" value="${customerList.getGender()}">
                <label for="gender">Gender</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="date_of_birth" type="date" name="date_of_birth" value="${customerList.getDate_of_birth()}">
                <label for="date_of_birth">Date Of Birth</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="id_card" type="text" name="id_card" value="${customerList.getId_card()}">
                <label for="id_card">Id Card</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="phone_number" type="text" name="phone_number" value="${customerList.getPhone_number()}">
                <label for="phone_number">Phone Number</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="email" type="text" name="email" value="${customerList.getEmail()}">
                <label for="email">Email</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="address" type="text" name="address" value="${customerList.getAddress()}">
                <label for="address">Address</label>
            </div>
            <div class="form-floating mb-3">
                <select name="customer_type_id" class="form-select" aria-label="Default select example"
                        style="padding: 0 20px">
                    <c:forEach var="customerType" items="${customerTypeList}">
                        <option value="${customerType.id}">
                                ${customerType.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-floating mb-3">
                <select name="user_id" class="form-select" aria-label="Default select example"
                        style="padding: 0 20px">
                    <c:forEach var="user" items="${userList}">
                        <option value="${user.id}">
                                ${user.user_name}
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
