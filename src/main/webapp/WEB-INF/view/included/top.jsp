<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

<header>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="brand">
			<a href="${pageContext.request.contextPath}/home"><img
				src="${pageContext.request.contextPath}/assets/img/logo-dark.png"
				alt="Klorofil Logo" class="img-responsive logo"></a>
		</div>
		<div class="container-fluid">
			<div class="navbar-btn">
				<button type="button" class="btn-toggle-fullwidth">
					<i class="lnr lnr-arrow-left-circle"></i>
				</button>
			</div>

			<form:form action="#" class="navbar-form navbar-left">
				<div class="input-group">
					<input type="text" value="" class="form-control"
						placeholder="Search dashboard..."> <span
						class="input-group-btn"><button type="button"
							class="btn btn-primary">Go</button></span>
				</div>
			</form:form>

			<div id="navbar-menu">
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${!empty sessionScope.login}">
							<li class="dropdown"><a href="#"
								class="dropdown-toggle icon-menu" data-toggle="dropdown"> <i
									class="lnr lnr-alarm"></i> <span class="badge bg-danger"><c:if
											test="${!empty sessionScope.messageLength}">${sessionScope.messageLength }</c:if></span></a>
								<ul class="dropdown-menu notifications">
									<c:forEach var="messagecommand"
										items="${sessionScope.messagecommands }" varStatus="status">
										<c:if test="${!messagecommand.read }">
											<li><a
												href="${pageContext.request.contextPath}/profile/messageDetail/${messagecommand.messageNumber}"
												class="notification-item"><span class="dot bg-danger"></span>${messagecommand.title }</a></li>
										</c:if>
									</c:forEach>
									<li><a
										href="${pageContext.request.contextPath}/profile/message/${sessionScope.login.memberNumber}"
										class="more">See all message</a></li>
								</ul></li>
						</c:when>
					</c:choose>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <c:choose>
								<c:when test="${!empty sessionScope.login}">
									<img class="img-circle" width="30" height="20"
										src="${pageContext.request.contextPath}/upload/${sessionScope.login.image.imagePath}">
								</c:when>
								<c:otherwise>
									<img
										src="${pageContext.request.contextPath}/assets/img/favicon.png"
										class="img-circle" alt="image">
								</c:otherwise>
							</c:choose><span>${sessionScope.login.memberName}</span> <i
							class="icon-submenu lnr lnr-chevron-down"></i></a>
						<ul class="dropdown-menu">
							<c:choose>
								<c:when test="${empty sessionScope.login}">
									<li><a href="${pageContext.request.contextPath}/login"><i
											class="lnr lnr-enter"></i> <spring:message code="title.login" /></a></li>
									<li><a
										href="${pageContext.request.contextPath}/signup/step1"><i
											class="lnr lnr-pencil"></i> <spring:message
												code="register.member" /></a></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="${pageContext.request.contextPath}/profile/refresh"><i
											class="lnr lnr-user"></i> <span>Profile</span></a></li>
									<li><a
										href="${pageContext.request.contextPath}/profile/message"><i
											class="lnr lnr-envelope"></i> <span>Message</span></a></li>
									<li><a href="${pageContext.request.contextPath}/edit"><i
											class="lnr lnr-cog"></i> <span>Settings</span></a></li>
									<li><a href="${pageContext.request.contextPath}/logout"><i
											class="lnr lnr-exit"></i> <span>Logout</span></a></li>
								</c:otherwise>
							</c:choose>
						</ul></li>
					<li><c:if
							test="${sessionScope.login.memberlevel.memberLevelCode == 1}">
							<a href="${pageContext.request.contextPath}/admin/refresh"><i
								class="lnr lnr-cog"></i></a>
						</c:if></li>
				</ul>
			</div>
		</div>
	</nav>
</header>