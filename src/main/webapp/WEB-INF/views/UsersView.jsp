<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <script src="/bootstrap/js/jquery.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/" method="post">
        Login : <input type="text" name="login"><br/>
        Email : <input type="text" name="email"><br/>
        <input type="submit">
    </form><br/>

    <table style="border: 1px solid black;" cellpadding="1" border="1">
            <tr>
                <th>login</th>
                <th>email</th>
                <th>id</th>
            </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><a href="${pageContext.servletContext.contextPath}/Items.html?id=${user.id}">
                    <c:out value="${user.login}"></a></c:out></td>
                <td><c:out value="${user.email}"></c:out></td>
                <td><c:out value="${user.id}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>


