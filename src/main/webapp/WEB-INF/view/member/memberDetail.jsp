<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.info" /></title>
</head>
<body>
	<p>
		<spring:message code="id" />
		: ${member.id }
	</p>
	<p>
		<spring:message code="email" />
		: ${member.email }
	</p>
	<p>
		<spring:message code="name" />
		: ${member.name }
	</p>
	<p>
		<spring:message code="registerDate" />
		:
		<tf:formatDateTime value="${member.registerDateTime }"
			pattern="yyyy-MM-dd HH:mm" />
	</p>
	<p>
		<a href="<c:url value="/members" />">[<spring:message code="member.list" />]</a>
	</p>
</body>
</html>