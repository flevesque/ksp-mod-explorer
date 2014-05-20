<%--
  User: Francois Levesque <francois@critical-web.com>
  Date: 20/05/14
  Time: 10:46 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="global.title" /></title>
</head>
<body>

<p>thanks for registering</p>

<p>display name: ${user.displayname}</p>
<p>e-mail: ${user.email}</p>
<p>username: ${user.username}</p>

</body>
</html>
