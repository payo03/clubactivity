<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title.login" /></title>
</head>
<body>
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<div id="main">
		<form:form action="${pageContext.request.contextPath}/login"
			method="post" modelAttribute="loginRequest">

			<h1>
				<spring:message code="title.login" />
			</h1>

			<label style="margin-top: 20px"> <form:input path="memberId"
					placeholder="ID" onfocus="this.placeholder = ''"
					onblur="this.placeholder = 'ID'" /> <form:errors path="memberId" />
			</label>
			<br>
			<label> <form:password path="memberPassword"
					placeholder="Password" onfocus="this.placeholder = ''"
					onblur="this.placeholder = 'Password'" /> <form:errors
					path="memberPassword" />
			</label>
			<br>
			<br>
			<div>
				<form:checkbox path="memory" />
				<spring:message code="memberId.remember" />
			</div>

			<button id="btn_login" type="submit">
				<spring:message code="btn.login" />
			</button>

		</form:form>

	</div>

	<c:import url="../included/bottom.jsp">
		<c:param value="main" name="type" />
	</c:import>

</body>
<script defer type="text/javascript" charset="utf-8">
	 $("#btn_login").click(function() {
		if ($("#memberId").val() == "") {
			alert("이메일을 입력해주세요.");
			return false;
		} else if ($("#memberPassword").val() == "") {
			alert("비밀번호을 입력해주세요.");
			return false;
		}
	});
</script>

</html>