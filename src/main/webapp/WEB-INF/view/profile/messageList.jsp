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

		<!-- LEFT -->
		<c:import url="../included/left.jsp">
			<c:param value="main" name="type" />
		</c:import>
		<!-- LEFT END -->

		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h3 class="panel-title">Message List</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<c:forEach var="messagecommand" items="${messagecommands}"
									varStatus="status">
									<div class="col-md-3">
										<div class="metric">
											<span class="icon"><i class="lnr lnr-envelope"></i></span>
											<p>
												<span class="number">${messagecommand.title }</span> <span
													class="title"> ${messagecommand.title }</span>
											</p>
										</div>
									</div>
								</c:forEach>
							</div>
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
</body>

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