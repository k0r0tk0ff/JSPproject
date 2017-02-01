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
    <h3>Edit user</h3>
    <%--<form action="${pageContext.servletContext.contextPath}/" method="post">--%>
    <form action="${pageContext.servletContext.contextPath}/user/edit.do" method="post">
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
</body>
</html>