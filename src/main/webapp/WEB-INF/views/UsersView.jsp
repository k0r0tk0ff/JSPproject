<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>MainMenu</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<%--
    <link rel="stylesheet" href="../bootstrap.min.css">
    <script src="../jquery.min.js"></script>
    <script src="../bootstrap.min.js"></script>
--%>
<%--    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}dist/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}dist/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="../../dist/css/bootstrap.min.css">
    <script src="../../dist/js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
</head>
<body>

    <!-- Creade form for add user-->
<%--    <form action="${pageContext.servletContext.contextPath}/" method="post">
        Login : <input type="text" name="login"><br/>
        Email : <input type="text" name="email"><br/>
        <input type="submit">
    </form><br/>--%>

    <div class="container">
        <h3>Add user</h3>
        <form action="${pageContext.servletContext.contextPath}/" method="post">
                <div class="input-group">
                    <span class="input-group-addon">Login</span>
                    <input id="login" type="text" class="form-control" name="login" placeholder="Login">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">Email </span>
                    <input id="email" type="email" class="form-control" name="email" placeholder="Email">
                </div>
            <input type="submit" class="btn btn-info" value="add User">
            <%--<input type="submit">--%>
        </form>
    </div>

    <table style="border: 1px solid black;" cellpadding="1" border="1">
            <tr>
                <th>login</th>
                <th>email</th>
                <th>id</th>
            </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.login}"></c:out></td>
                <td><c:out value="${user.email}"></c:out></td>
                <td><c:out value="${user.id}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>


