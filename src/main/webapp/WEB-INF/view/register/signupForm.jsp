<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title><spring:message code="main" /></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor/linearicons/style.css">
<!-- MAIN CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/demo.css">
<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="${pageContext.request.contextPath}/assets/img/favicon.png">
</head>

<body>
	<div id="wrapper">
		<!-- HEADER -->
		<c:import url="../included/top.jsp">
			<c:param value="main" name="type" />
		</c:import>
		<!-- HEADER END -->

		<br>
		<!-- MAIN -->
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box lockscreen"
					style="width: 40%; height: 80%">
					<div class="content">
						<div class="logo text-center">
							<form:form
								action="${pageContext.request.contextPath}/signup/step2"
								method="post" modelAttribute="memberRegisterRequest">
								<h3>
									<spring:message code="register.member" />
								</h3>
								<br>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<form:input path="memberId" placeholder="EMAIL"
										onfocus="this.placeholder = 'ID'"
										onblur="this.placeholder = 'EMAIL'" class="form-control" />
								</div>
								<form:errors path="memberId" />
								<br>

								<div class="input-group">
									<span class="input-group-addon"><i class="lnr lnr-lock"></i></span>
									<form:password path="memberPassword" placeholder="PASSWORD"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'PASSWORD'" class="form-control" />
								</div>
								<form:errors path="memberPassword" />
								<br>

								<div class="input-group">
									<span class="input-group-addon"><i class="lnr lnr-lock"></i></span>
									<form:password path="checkPassword" placeholder="PASSWORD"
										onfocus="this.placeholder = 'CHECK PASSWORD'"
										onblur="this.placeholder = 'PASSWORD'" class="form-control" />
								</div>
								<form:errors path="checkPassword" />
								<br>

								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<form:input path="memberName" placeholder="NAME"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'NAME'" class="form-control" />
								</div>
								<form:errors path="memberName" />
								<br>

								<div class="input-group">
									<span class="input-group-addon"><i
										class="lnr lnr-smartphone"></i></span>
									<form:input path="memberPhoneNumber" placeholder="PHONE"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'PHONE'"
										onKeyup="inputPhoneNumber(this);" maxlength="13"
										pattern=".{13,13}" class="form-control" />

								</div>
								<form:errors path="memberPhoneNumber" />
								<br>

								<div class="input-group">
									<span class="input-group-addon"><i class="lnr lnr-home"></i></span>
									<form:input path="memberWebsite" placeholder="WEBSITE"
										onfocus="this.placeholder = 'https://'"
										onblur="this.placeholder = 'WEBSITE'" class="form-control" />

								</div>
								<form:errors path="memberWebsite" />
								<br>

								<button id="btn_register" type="submit" class="btn btn-primary">
									<spring:message code="btn.register" />
								</button>
								<br>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- MAIN END -->

		<!-- FOOTER -->
		<c:import url="../included/bottom.jsp">
			<c:param value="main" name="type" />
		</c:import>
		<!-- FOOTER END -->
	</div>
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

<script
	src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/vendor/chartist/js/chartist.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/scripts/klorofil-common.js"></script>

</html>