<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.login" /></title>
</head>
<body class="text-center">

	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<div id="main">
		<p>
			<spring:message code="done.register">
				<spring:argument value="${memberRegisterRequest.memberName}" />
				<spring:argument value="${memberRegisterRequest.memberId}" />
			</spring:message>
		</p>
	</div>

	<c:import url="../included/bottom.jsp">
		<c:param value="main" name="type" />
	</c:import>
</body>
</html>