<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 10/13/2023
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>update</title>
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
                    <input type="text" class="form-control" name="id" value="<c:out value="${employeeList.id}"/>" >
                    <span class="input-group-text"> <i class="fa-solid fa-person-circle-question"></i></span>
                </div>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="name" type="text" name="name" value="<c:out value="${employeeList.name}"/>">
                <label for="name">FullName</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="gender" type="text" name="gender" value="${employeeList.gender}">
                <label for="gender">Gender</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="date_of_birth" type="date" name="date_of_birth" value="${employeeList.date_of_birth}">
                <label for="date_of_birth">Date Of Birth</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="id_card" type="number" name="id_card" value="${employeeList.id_card}">
                <label for="id_card">Id Card</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="phone_number" type="number" name="phone_number" value="${employeeList.phone_number}">
                <label for="phone_number">Phone Number</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="email" type="email" name="email" value="${employeeList.email}">
                <label for="email">Email</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="address" type="text" name="address" value="${employeeList.address}">
                <label for="address">Address</label>
            </div>
            <div class="form-floating mb-3">
                <input class="form-control" id="salary" type="number" name="salary" value="${employeeList.salary}">
                <label for="salary">Salary</label>
            </div>
            <div class="form-floating mb-3">
                <select name="position_id" class="form-select" aria-label="Default select example"
                        style="padding: 0 20px">
                    <c:forEach var="position" items="${positionList}">
                        <option value="${position.id}">
                                ${position.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-floating mb-3">
                <select name="department_id" class="form-select" aria-label="Default select example"
                        style="padding: 0 20px">
                    <c:forEach var="department" items="${departmentList}">
                        <option value="${department.id}">
                                ${department.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-floating mb-3">
                <select name="education_degree_id" class="form-select" aria-label="Default select example"
                        style="padding: 0 20px">
                    <c:forEach var="educationDegree" items="${educationDegreeList}">
                        <option value="${educationDegree.id}">
                                ${educationDegree.name}
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

            <button class="btn btn-lg btn-success" type="submit" value="update">Update</button>
        </form>
    </div>
    <div class="col-2"></div>
</div>
</body>
</html>
