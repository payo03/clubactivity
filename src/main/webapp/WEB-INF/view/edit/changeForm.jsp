<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="main" /></title>
</head>
<body>
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>
	
	<a href="${pageContext.request.contextPath}/edit/numberForm"><spring:message code="number.edit" /></a>
	<a href="${pageContext.request.contextPath}/edit/passwordForm"><spring:message code="password.edit" /></a>
	
	<c:import url="../included/bottom.jsp">
		<c:param value="main" name="type" />
	</c:import>

</body>
</html>