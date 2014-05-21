<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags" %>
<%--
  User: Francois Levesque <francois@critical-web.com>
  Date: 5/19/14
  Time: 9:01 AM
--%>
<html>
<head>
	<title><spring:message code="global.title"/></title>
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
		<p>If you're not already registered, click the button below.</p>

		<p><a class="btn btn-primary btn-lg uppercase" role="button"
			  href="<%= request.getContextPath() %>/login/register">Register</a></p>
	</div>
</div>

<div class="container">
	<h3 class="col-md-offset-4 col-md-4 uppercase"><spring:message code="form.login.title"/></h3>

	<form:form class="form-horizontal" action="${pageContext.request.contextPath}/login/" method="post"
			   modelattribute="login" commandName="login">
		<form:errors class="alert alert-danger bold col-md-offset-4 col-md-4" element="div" htmlEscape="false" />

		<spring:bind path="username">
			<f:loginField name="username" status="${status}" root="form.login"/>
		</spring:bind>

		<spring:bind path="password">
			<f:loginField name="password" status="${status}" root="form.login" password="true"/>
		</spring:bind>

		<div class="form-group">
			<div class="col-md-offset-4 col-md-4">
				<div class="checkbox">
					<label>
						<input type="checkbox"> <spring:message code="form.login.fields.rememberme.name"/>
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4 col-md-4">
				<button type="submit" class="btn btn-default uppercase"><spring:message
						code="form.login.fields.submit.name"/></button>
			</div>
		</div>
	</form:form>
</div>

</body>
</html>
