<%--
  User: Francois Levesque
  Date: 5/19/14
  Time: 12:19 AM
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><decorator:title /></title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/custom.css"/>
</head>
<body>

	<div id="wrap">
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%= request.getContextPath() %>">LOGO</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Link</a></li>
			</ul>
			<br />

		</nav>
		<div class="page-header">
			<h1><spring:message code="global.title" />
				<small><spring:message code="global.title.subtext" /></small>
			</h1>
		</div>

		<decorator:body />

		<div id="push"></div>
	</div>

	<div id="footer" th:fragment="footer">
		<div class="container">
			<p class="credit"><spring:message code="global.footer" /></p>
		</div>
	</div>

	<script type="application/javascript" src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
</body>
</html>
