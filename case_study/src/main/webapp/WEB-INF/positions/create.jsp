<%--
  Created by IntelliJ IDEA.
  User: DAT
  Date: 10/9/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Position</title>
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
            <div class="form-floating mb-3">
                <input class="form-control" id="name" type="text" name="name">
                <label for="name">Name</label>
            </div>
            <%--            <div class="form-floating mb-3">--%>
            <%--                <select class="form-select" id="floatingSelect1" name="subCategoryId" aria-label="Floating label select example">--%>
            <%--                    <option selected> Select Category</option>--%>
            <%--                    <c:forEach varStatus="status" var="category" items="${categories}">--%>
            <%--                        <option value="${category.id}">${category.name}</option>--%>
            <%--                    </c:forEach>--%>
            <%--                </select>--%>
            <%--            </div>--%>
            <button class="btn btn-lg btn-success" type="submit" value="create">Create</button>
        </form>
    </div>
    <div class="col-2"></div>
</div>
</body>
</html>
