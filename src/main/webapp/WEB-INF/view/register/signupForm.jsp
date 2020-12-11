<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="register.member" /></title>
</head>
<body>
	<c:import url="../included/top.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<div id="main">
		<div style="text-align: left">
			<form:form action="${pageContext.request.contextPath}/signup/step2"
				method="post" modelAttribute="memberRegisterRequest"
				onsubmit="return validate()">
				<h1>
					<spring:message code="register.member" />
				</h1>
				<br>

				<form:errors />
				<br>
				<br>
				<label> <form:input path="memberId" placeholder="아이디"
						onfocus="this.placeholder = 'ID'"
						onblur="this.placeholder = '아이디'" />
				</label>
				<label> <form:errors path="memberId" />
				</label>

				<br>

				<label> <form:password path="memberPassword"
						placeholder="비밀번호" onfocus="this.placeholder = ''"
						onblur="this.placeholder = '비밀번호'" />

				</label>
				<label> <form:errors path="memberPassword" />
				</label>

				<br>
				<label> <form:password path="checkPassword"
						placeholder="비밀번호 확인" onfocus="this.placeholder = ''"
						onblur="this.placeholder = '비밀번호 확인'" />
				</label>
				<label> <form:errors path="checkPassword" />
				</label>

				<br>
				<label> <form:input path="memberName" placeholder="이름"
						onfocus="this.placeholder = ''" onblur="this.placeholder = '이름'" />
				</label>
				<label> <form:errors path="memberName" />
				</label>
				<br>
				<label> <form:input path="memberPhoneNumber"
						placeholder="전화번호" onfocus="this.placeholder = ''"
						onblur="this.placeholder = '전화번호'"
						onKeyup="inputPhoneNumber(this);" maxlength="13"
						pattern=".{13,13}" />

				</label>
				<label> <form:errors path="memberPhoneNumber" />
				</label>
				<br>

				<button id="btn_register" type="submit">
					<spring:message code="btn.register" />
				</button>
				<br>
			</form:form>

		</div>
	</div>

	<c:import url="../included/bottom.jsp">
		<c:param value="main" name="type" />
	</c:import>

	<script>
		function inputPhoneNumber(obj) {

			var number = obj.value.replace(/[^0-9]/g, "");
			var phone = "";

			if (number.length < 4) {
				return number;
			} else if (number.length < 7) {
				phone += number.substr(0, 3);
				phone += "-";
				phone += number.substr(3);
			} else if (number.length < 11) {
				phone += number.substr(0, 3);
				phone += "-";
				phone += number.substr(3, 3);
				phone += "-";
				phone += number.substr(6);
			} else {
				phone += number.substr(0, 3);
				phone += "-";
				phone += number.substr(3, 4);
				phone += "-";
				phone += number.substr(7);
			}
			obj.value = phone;
		}
	</script>
</body>
<script defer type="text/javascript" charset="utf-8">
	 $("#btn_register").click(function() {
		if ($("#memberId").val() == "") {
			alert("이메일을 입력해주세요.");
			return false;
		} else if ($("#memberPassword").val() == "") {
			alert("비밀번호을 입력해주세요.");
			return false;
		} else if ($("#memberPassword").val() != $("#checkPassword").val()) {
			alert("비밀번호와 비밀번호 확인란이 동일하지 않습니다.");
			return false;
		} else if ($("#memberName").val() == "") {
			alert("이름을 입력해주세요.");
			return false;
		} else if ($("#memberPhoneNumber").val() == "") {
			alert("전화번호를 입력해주세요.");
			return false;
		}
	});
</script>

</html>