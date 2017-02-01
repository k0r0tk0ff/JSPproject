<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: k0r0tk0ff
  Date: 2/1/2017
  Time: 9:46 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MainMenu</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Edit user <c:out value="${user.login}"></c:out></h3>
    <%--<form action="${pageContext.servletContext.contextPath}/" method="post">--%>
    <form action="${pageContext.servletContext.contextPath}/users/edit.do" method="post">
        <div class="input-group">
            <span class="input-group-addon">Login</span>
            <input id="newLogin" type="text" class="form-control" name="newLogin" placeholder="">
        </div>
        <div class="input-group">
            <span class="input-group-addon">Email</span>
            <input id="newEmail" type="email" class="form-control" name="newEmail" placeholder="">
        </div>
        <div class="input-group">
            <span class="input-group-addon">Id</span>
            <input id="Id" type="hidden" class="form-control" name="id">
        </div>
        <div class="input-group">
            <span class="input-group-addon">Password</span>
            <input id="newPassword" type="password" class="form-control" name="newPassword" placeholder="">
        </div>
        <br/>
        <input type="submit" class="btn btn-info" value="Edit User">
    </form>
</div>
<br/>

<!-- Bootstrap table-->
<div class="container">
    <h2>Pet`s clinic customer</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>login</th>
            <th>email</th>
            <th>id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="iterator">
            <tr>
                <td><c:out value="${iterator.login}"></c:out></td>
                <td><c:out value="${iterator.email}"></c:out></td>
                <td><c:out value="${iterator.id}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
</div>
<br/>
</body>
</html>