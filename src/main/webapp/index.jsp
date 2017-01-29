<%@ page import="services.UserStorage" %>
<%@ page import="models.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  @autor Peter Arsentev
  @student k0r0tk0ff
  Date: 1/29/2017
  Time: 10:05 AM
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>

    <!-- Build a table where we can register a user-->
    <form action="<%=request.getContextPath()%>" method="post">
        Login : <input type="text" name="Login"></br>
        Email : <input type="text" name="Email"></br>
        Id : <input type="text" name="Id"></br>
        Password: <input type="text" name="Password"></br>
        <input type="submit">
    </form>

    <!-- Build a table where we can see registered users-->
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
