<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ attribute name="name" required="true" %>
<%@ attribute name="status" required="true" %>
<%@ attribute name="root" required="false" %>
<%@ attribute name="password" required="false" type="java.lang.Boolean" %>

<c:if test="${empty root}">
	<c:set var="root" value="form.register" />
</c:if>

<c:if test="${password == null}">
	<c:set var="password" value="false" />
</c:if>

<spring:bind path="${name}">

	<div class="form-group ${status.error ? 'has-error' : ''}">
		<div class="col-md-offset-4 col-md-4">
			<spring:message code="${root}.placeholder.${name}" var="placeholder" />
			<c:choose>
				<c:when test="${password}">
					<form:password path="${name}" placeholder="${placeholder}" cssClass="form-control" />
				</c:when>
				<c:otherwise>
					<form:input path="${name}" placeholder="${placeholder}" cssClass="form-control" />
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-md-4">
			<form:errors path="${name}" class="help-block" />
		</div>
	</div>
</spring:bind>