<%--
  @autor Peter Arsentev
  @student k0r0tk0ff
  Date: 1/29/2017
  Time: 10:05 AM
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/users" method="post">
        Login : <input type="text" name="Login"></br>
        Email : <input type="text" name="Email"></br>
        Id : <input type="text" name="Id"></br>
        <input type="submit"></br>
    </form>
</body>
</html>
