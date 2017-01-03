<%@ page import="models.User" %>
<%@ page import="services.UserStorage" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta >
    <title>Title for JSP page</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/" method="post">
    Login : <input type="text" name="login"><br/>
    Email : <input type="text" name="email"><br/>
        <input type="submit">
    </form>
    <br/>
    <table style="border: 1pc solid black;" cellpadding="1" border="1">
    <tr>
        <th>login</th>
        <th>email</th>
    </tr>
        <%-- Use binded attribute - "users", --%>
        <%-- that contain "UserStorage.getInstance().getAll()" --%>
        <%--     --%>
        <%-- do not work  --%>
        <% for (User user : (List<User>) request.getAttribute("users")) {%>
        <%-- for (User user : UserStorage.getInstance().getAll()) {--%>
        <c:forEach items="$users" var="user">
        <tr>
            <td><%=user.getlogin()%></td>
            <td><%=user.getemail()%></td>
        </tr>
        <% }%>
    </table>
</body>
</html>