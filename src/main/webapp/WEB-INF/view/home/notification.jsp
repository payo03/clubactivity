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
					<h3 class="page-title">Notifications</h3>
					<div id="toastr-demo" class="panel">
						<div class="panel-body">
							<!-- CONTEXTUAL -->
							<h4>Context</h4>
							<p class="demo-button">
								<button type="button" class="btn btn-primary btn-toastr"
									data-context="info" data-message="This is general theme info"
									data-position="top-right">General Info</button>
								<button type="button" class="btn btn-success btn-toastr"
									data-context="success" data-message="This is success info"
									data-position="top-right">Success Info</button>
								<button type="button" class="btn btn-warning btn-toastr"
									data-context="warning" data-message="This is warning info"
									data-position="top-right">Warning Info</button>
								<button type="button" class="btn btn-danger btn-toastr"
									data-context="error" data-message="This is error info"
									data-position="top-right">Error Info</button>
							</p>
							<!-- END CONTEXTUAL -->
							<br>
							<!-- POSITION -->
							<h4>Position</h4>
							<p class="demo-button">
								<button type="button" class="btn btn-default btn-toastr"
									data-context="info" data-message="Hi, I'm here"
									data-position="bottom-right">Bottom Right</button>
								<button type="button" class="btn btn-default btn-toastr"
									data-context="info" data-message="Hi, I'm here"
									data-position="bottom-left">Bottom Left</button>
								<button type="button" class="btn btn-default btn-toastr"
									data-context="info" data-message="Hi, I'm here"
									data-position="top-left">Top Left</button>
								<button type="button" class="btn btn-default btn-toastr"
									data-context="info" data-message="Hi, I'm here"
									data-position="top-right">Top Right</button>
								<button type="button" class="btn btn-default btn-toastr"
									data-context="info" data-message="Hi, I'm here"
									data-position="top-full-width">Top Full Width</button>
								<button type="button" class="btn btn-default btn-toastr"
									data-context="info" data-message="Hi, I'm here"
									data-position="bottom-full-width">Bottom Full Width</button>
								<button type="button" class="btn btn-default btn-toastr"
									data-context="info" data-message="Hi, I'm here"
									data-position="top-center">Top Center</button>
								<button type="button" class="btn btn-default btn-toastr"
									data-context="info" data-message="Hi, I'm here"
									data-position="bottom-center">Bottom Center</button>
							</p>
							<!-- END POSITION -->
							<br>
							<!-- CALLBACK -->
							<h4>Callback</h4>
							<p class="demo-button">
								<button type="button"
									class="btn btn-default btn-toastr-callback"
									id="toastr-callback1" data-context="info"
									data-message="onShown and onHidden callback demo">onShown
									and onHidden</button>
								<button type="button"
									class="btn btn-default btn-toastr-callback"
									id="toastr-callback2" data-context="info"
									data-message="Please click me">onclick</button>
								<button type="button"
									class="btn btn-default btn-toastr-callback"
									id="toastr-callback3" data-context="info"
									data-message="Please click close button">onCloseClick</button>
							</p>
							<!-- END CALLBACK -->
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