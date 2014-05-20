<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  User: Francois Levesque <francois@critical-web.com>
  Date: 5/19/14
  Time: 9:01 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
			<p>If you're not already registered, click the button below.</p>
			<p><a class="btn btn-primary btn-lg uppercase" role="button" href="<%= request.getContextPath() %>/login/register">Register</a></p>
		</div>
	</div>

	<div class="container">
		<h3 class="col-md-offset-4 col-md-4 uppercase">Login</h3>
		<form class="form-horizontal">
			<div class="form-group">
				<div class="col-md-offset-4 col-md-4">
					<input type="text" class="form-control" name="username" id="username" placeholder="Enter your username" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-4 col-md-4">
					<input type="password" class="form-control" name="password" id="password" placeholder="Enter your password" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-4 col-md-4">
					<div class="checkbox">
						<label>
							<input type="checkbox"> Remember me
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-4 col-md-4">
					<button type="submit" class="btn btn-default uppercase">Sign in</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
