<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="servlets.UsersController" %>
<%@ page import="services.UserStorage" %>
<%@ page import="models.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%--
  @autor Peter Arsentev
  @student k0r0tk0ff
  Date: 1/29/2017
  Time: 10:05 AM
 --%>

<html>
<head>
    <title>index.jsp</title>
</head>
<body>

<%--    <!-- Build a table where we can register a user-->
    <form action="${pageContext.servletContext.contextPath}/" method="post">
        Login : <input type="text" name="login"></br>
        Email : <input type="text" name="email"></br>
        Id : <input type="text" name="id"></br>
        Password: <input type="text" name="password"></br>
        <input type="submit">
    </form>--%>

    <!-- Build a table where we can see registered users with JSTL-->
<%--    <table style="border: 1px solid black;" cellpadding="1" border="1">
        <tr>
            <th>login</th>
            <th>email</th>
            <th>id</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr valign="top">
                <td><c:out value="${user.Login}"></c:out></td>
                <td><c:out value="${user.Email}"></c:out></td>
                <td><c:out value="${user.Id}"></c:out></td>
        </c:forEach>
    </table>--%>

 <!-- Build a table where we can register a user-->
    <form action="<%=request.getContextPath()%>" method="post">
        Login : <input type="text" name="login"></br>
        Email : <input type="text" name="email"></br>
        Id : <input type="text" name="id"></br>
        Password: <input type="text" name="password"></br>
        <input type="submit">
    </form>

        <!-- Work realization wth java tegs-->
        <table style="border: 1px solid black;" cellpadding="1" border="1">
        <tr>
            <th>login</th>
            <th>email</th>
        </tr>
        <%
            for(User user : UserStorage.getInstance().getAll()) {
        %>
        <tr>
            <td><%=user.getLogin()%></td>
            <td><%=user.getEmail()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
