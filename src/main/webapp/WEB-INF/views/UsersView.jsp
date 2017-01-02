<%@ page import="models.User" %>
<%@ page import="services.UserStorage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <% for (User user : UserStorage.getInstance().getAll()) {%>
        <tr>
            <td><%=user.getlogin()%></td>
            <td><%=user.getemail()%></td>
        </tr>
        <% }%>
    </table>
</body>
</html>