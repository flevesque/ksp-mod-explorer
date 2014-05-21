<%--
  User: Francois Levesque <francois@critical-web.com>
  Date: 5/18/14
  Time: 2:19 PM
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="global.title" /></title>
</head>
<body>

<p>User in session: ${sessionScope.sessionUser.displayname}</p>

</body>
</html>
