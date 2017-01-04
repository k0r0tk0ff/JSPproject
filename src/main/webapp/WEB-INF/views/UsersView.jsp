<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="servlets.UsersController" %>
<%@ page import="services.UserStorage" %>
<%@ page import="models.User" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
     <title></title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/" method="post">
        Login : <input type="text" name="login"><br/>
        Email : <input type="text" name="email"><br/>
        <input type="submit">
    </form>
    <br/>

    <%-- work wariant
    <table style="border: 1px solid black;" cellpadding="1" border="1">
        <tr>
            <th>login</th>
            <th>email</th>
        </tr>
        <%
            for(User user : (List<User>) request.getAttribute("users")) {
        %>
        <tr>
            <td><%=user.getLogin()%></td>
            <td><%=user.getEmail()%></td>
        </tr>
        <%
            }
        %>
    </table>
    --%>


    <table style="border: 1px solid black;" cellpadding="1" border="1">
            <tr>
                <th>login</th>
                <th>email</th>
            </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                 <td><c:out value="${user.login}"></c:out></td>
                 <td><c:out value="${user.email}"></c:out></td>
            </tr>
        </c:forEach>
    </table>


    <%-- work variant
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
    --%>
</body>
</html>