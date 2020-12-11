<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<c:if test="${empty authInfo }" >
		<p>환영합니다</p>
		<p>
			<a href="<c:url value="/register/step1" />">[<spring:message code="register.member" /> ]</a>
			<a href="<c:url value="/login" />">[<spring:message code="title.login" />]</a>
		</p>
	</c:if>
	
	<c:if test="${!empty authInfo }" >
		<p>${authInfo.name }님, 환영합니다</p>
		<p>
			<a href="<c:url value="/edit/changePassword" />">[<spring:message code="password.edit" />]</a>
			<a href="<c:url value="/logout" />">[<spring:message code="title.logout" />]</a>
		</p>
		<p>
			<a href="<c:url value="/members" />">[<spring:message code="member.list" />]</a>
			<a href="<c:url value="/main" />">[<spring:message code="go.main" />]</a>
		</p>
	</c:if>
</body>
</html>