<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en" class="fullscreen-bg">
<head>
<title><spring:message code="title.login" /></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/linearicons/style.css">
<!-- MAIN CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/demo.css">
<!-- GOOGLE FONTS -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">
								<div class="logo text-center">
									<img src="${pageContext.request.contextPath}/assets/img/school.png" alt="연암공과대학교"><br>
									<img src="${pageContext.request.contextPath}/assets/img/school-logo.png" alt="연암공과대학교 로고">
								</div>
								<p class="lead">Login to your account</p>
							</div>
							<form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="loginRequest" class="form-auth-small">
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only">Email</label>
									<form:input path="memberId" placeholder="ID"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'ID'" class="form-control"
										id="signin-email" />
									<form:errors path="memberId" />
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">Password</label>
									<form:password path="memberPassword" placeholder="Password"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Password'" class="form-control"
										id="signin-password" />
									<form:errors path="memberPassword" />
								</div>
								<div class="form-group clearfix">
									<label class="fancy-checkbox element-left"> <input type="checkbox" name="memory"/> 
									<span><spring:message code="memberId.remember" /></span>
									</label>
								</div>
								<button id="btn_login" type="submit"
									class="btn btn-primary btn-lg btn-block">
									<spring:message code="btn.login" />
								</button>
							</form:form>
						</div>
					</div>
					<div class="right">
						<div class="content text">
							<h1 class="heading">뉴칼라 인재를 만드는 연암공과대학교</h1>
							<p></p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>

</html>
