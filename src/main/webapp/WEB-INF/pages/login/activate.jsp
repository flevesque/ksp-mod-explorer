<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: Francois Levesque
  Date: 5/25/14
  Time: 5:29 PM
--%>
<html>
<head>
	<title><spring:message code="global.title" /></title>
</head>
<body>

<c:set var="key" value="failure" />
<c:set var="cls" value="alert-danger" />
<c:if test="${success}">
	<c:set var="key" value="success" />
	<c:set var="cls" value="alert-success" />
</c:if>

<div class="jumbotron">
	<div class="container">

		<h1><spring:message code="activate.${key}.title" /></h1>

		<p class="alert ${cls}"><spring:message code="activate.${key}.copy" arguments="${user.displayname}" argumentSeparator=";" /></p>

	</div>
</div>

</body>
</html>
