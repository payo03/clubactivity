<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
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

<div id="sidebar-nav" class="sidebar">
	<div class="sidebar-scroll">
		<nav>
			<ul class="nav">
				<li><a href="#" class="active"><i class="lnr lnr-home"></i>
						<span>Dashboard</span></a></li>

				<li><a href="#" class=""><i class="lnr lnr-chart-bars"></i>
						<span>Charts</span></a></li>

				<li><a href="#" class=""><i class="lnr lnr-dice"></i> <span>Tables</span></a></li>

				<li><a href="#" class=""><i class="lnr lnr-alarm"></i> <span>Notifications</span></a></li>

				<li><a href="#" class=""><i class="lnr lnr-code"></i> <span>Elements</span></a></li>
				<c:choose>
					<c:when test="${!empty sessionScope.login}">
						<li><a href="#subPages" data-toggle="collapse"
							class="collapsed"><i class="lnr lnr-file-empty"></i> <span>Pages</span>
								<i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages" class="collapse ">
								<ul class="nav">
									<li><a href="${pageContext.request.contextPath}/profile"
										class="">Profile</a></li>
									<li><a
										href="${pageContext.request.contextPath}/profile/messageList/${sessionScope.login.memberNumber }"
										class="">Message</a></li>
									<li><a href="${pageContext.request.contextPath}/logout"
										class="">Logout</a></li>
								</ul>
							</div></li>
					</c:when>
				</c:choose>
				<li><a href="${pageContext.request.contextPath}/edit" class=""><i
						class="lnr lnr-cog"></i> <span>Settings</span></a></li>
			</ul>
		</nav>
	</div>
</div>