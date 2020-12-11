<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<form:form action="${pageContext.request.contextPath}/edit/form"
		method="post" modelAttribute="member">
		<p>
			<label><spring:message code="password" /> <form:input
					path="memberPassword" /> <form:errors path="memberPassword" /> </label>
		</p>
		<input type="submit" value="<spring:message code="checkPassword" />">
	</form:form>
	
	<c:import url="../included/bottom.jsp">
		<c:param value="main" name="type" />
	</c:import>
</body>
</html>