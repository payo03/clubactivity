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
<title><spring:message code="title.memberList" /></title>
</head>
<body>
	<form:form modelAttribute="listCommand">
	<p>
		<label>from: <form:input path="from" /></label>
		<form:errors path="from" />
		 ~
		<label>to:<form:input path="to" /></label>
		<form:errors path="to" />
		<input type="submit" value="<spring:message code="search" />">
	</p>
	</form:form>
	
	<c:if test="${! empty members }">
	<table>
		<tr>
			<th>아이디</th><th>이메일</th>
			<th>이름</th><th>가입일</th>
		</tr>
		<c:forEach var="member" items="${members}" >
		<tr>
			<td>${member.id }</td>
			<td><a href="<c:url value="/members/${member.id }" />">${member.email }</a></td>
			<td>${member.name }</td>
			<td><tf:formatDateTime value="${member.registerDateTime }" pattern="yyyy-MM-dd" /></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	
	<p>
		<a href="<c:url value="/main" />">[<spring:message code="go.main" />]</a>
	</p>
</body>
</html>