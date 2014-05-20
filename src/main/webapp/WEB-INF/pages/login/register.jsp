<%--
  User: Francois Levesque
  Date: 5/19/14
  Time: 9:41 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" tagdir="/WEB-INF/tags" %>
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
		<h3 class="col-md-offset-4 col-md-4 uppercase">Register</h3>
	</div>

	<form:form class="form-horizontal" action="${pageContext.request.contextPath}/login/register" method="post" modelattribute="register" commandName="register">
		<form:errors class="alert alert-danger col-md-offset-4 col-md-4" element="div"></form:errors>

		<spring:bind path="username">
			<f:loginField name="username" status="${status}" root="form.register" />
		</spring:bind>

		<spring:bind path="password">
			<f:loginField name="password" status="${status}" root="form.register" password="true" />
		</spring:bind>

		<spring:bind path="confirmPassword">
			<f:loginField name="confirmPassword" status="${status}" root="form.register" password="true" />
		</spring:bind>

		<spring:bind path="displayName">
			<f:loginField name="displayName" status="${status}" root="form.register" />
		</spring:bind>

		<spring:bind path="username">
			<f:loginField name="email" status="${status}" root="form.register" />
		</spring:bind>

		<%--<div class="form-group">--%>
			<%--<div class="col-md-offset-4 col-md-4">--%>
				<%--<form:input type="text" class="form-control" name="username" id="username" placeholder="Enter your username"  path="username" />--%>
				<%--<form:errors path="username" />--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="form-group">--%>
			<%--<div class="col-md-offset-4 col-md-4">--%>
				<%--<form:input type="password" class="form-control" name="password" id="password" placeholder="Enter your password"  path="password" />--%>
				<%--<form:errors path="password" />--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="form-group">--%>
			<%--<div class="col-md-offset-4 col-md-4">--%>
				<%--<form:input type="password" class="form-control" name="confirmPassword" id="confirmPassword" placeholder="Confirm your password"  path="confirmPassword" />--%>
				<%--<form:errors path="confirmPassword" />--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="form-group">--%>
			<%--<div class="col-md-offset-4 col-md-4">--%>
				<%--<form:input type="text" class="form-control" name="displayName" id="displayName" placeholder="Enter a display name" path="displayName" />--%>
				<%--<form:errors path="displayName" />--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<div class="form-group">--%>
			<%--<div class="col-md-offset-4 col-md-4">--%>
				<%--<form:input type="text" class="form-control" name="email" id="email" placeholder="Enter your e-mail address" path="email" />--%>
				<%--<form:errors path="email" />--%>
			<%--</div>--%>
		<%--</div>--%>
		<div class="form-group">
			<div class="col-md-offset-4 col-md-4">
				<button type="submit" class="btn btn-default uppercase">Register</button>
			</div>
		</div>
	</form:form>
</div>

</body>
</html>
