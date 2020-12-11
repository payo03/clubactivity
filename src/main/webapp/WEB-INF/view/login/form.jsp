<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="login">
		<label for ="loginType"> 로그인 타입 </label>
		<form:select path="loginType" itmes="${loginTypes }" />

	</form:form>

</body>
</html>