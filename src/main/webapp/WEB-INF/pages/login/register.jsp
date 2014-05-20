<%--
  User: Francois Levesque <francois@critical-web.com>
  Date: 5/19/14
  Time: 9:41 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title><spring:message code="global.title" /></title>
</head>
<body>

<div class="jumbotron">
	<div class="container">
		<h1>Login to KSP Mod Explorer</h1>
		<p>Login and registration confers many advantages, such as:</p>
		<ul>
			<li>Prizes!</li>
			<li>Reasons!</li>
			<li>bla bla!</li>
		</ul>
	</div>
</div>

<div class="container">

	<div class="row">
		<h3 class="col-md-offset-4 col-md-4 uppercase"><spring:message code="form.register.title"/></h3>
	</div>

	<form:form class="form-horizontal" action="${pageContext.request.contextPath}/login/register" method="post" modelattribute="register" commandName="register">
		<form:errors class="alert alert-danger bold col-md-offset-4 col-md-4" element="div"></form:errors>

        <c:if test="${userExists}">
            <div class="alert alert-danger bold col-md-offset-4 col-md-4">
                <spring:message code="form.register.userexists" arguments="${register.email}" />
            </div>
        </c:if>

		<spring:bind path="username">
			<f:loginField name="username" status="${status}" root="form.register" />
		</spring:bind>

		<spring:bind path="password">
			<f:loginField name="password" status="${status}" root="form.register" password="true" />
		</spring:bind>

		<spring:bind path="confirmPassword">
			<f:loginField name="confirmPassword" status="${status}" root="form.register" password="true" />
		</spring:bind>

		<spring:bind path="displayname">
			<f:loginField name="displayname" status="${status}" root="form.register" />
		</spring:bind>

		<spring:bind path="username">
			<f:loginField name="email" status="${status}" root="form.register" />
		</spring:bind>

		<div class="form-group">
			<div class="col-md-offset-4 col-md-4">
				<button type="submit" class="btn btn-default uppercase">Register</button>
			</div>
		</div>
	</form:form>
</div>

</body>
</html>
