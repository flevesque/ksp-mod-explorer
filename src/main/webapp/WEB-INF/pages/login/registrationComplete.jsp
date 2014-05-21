<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  User: Francois Levesque <francois@critical-web.com>
  Date: 20/05/14
  Time: 10:46 PM
--%>
<html>
<head>
    <title><spring:message code="global.title" /></title>
</head>
<body>

<spring:message code="global.title" var="title" />

<div class="jumbotron">
	<div class="container">
		<h1><spring:message code="form.register.complete.title" /></h1>
		<p><spring:message code="form.register.complete.message" arguments="${title}" /></p>
		<p><a class="btn btn-primary btn-lg uppercase" role="button" href="<%= request.getContextPath() %>/login"><spring:message code="form.register.complete.login"/></a></p>
	</div>
</div>

</body>
</html>
