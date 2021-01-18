<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<h3 class="page-title">
						<spring:message code="admin.member.manage" />
					</h3>
					<div class="row">
						<div class="panel">
							<div class="panel-heading">
								<!-- here -->
								<div id="serach_area" style="padding-bottom: 10px;">
									<form name="delivery" id="myForm" method="get">
										<input type="hidden" name="find_key" id="find_key"
											value="delivery_company_name" />
										<spring:message code="admin.search" />
										&nbsp;<input type="text" name="find_keyword" id="find_keyword"
											class="" /> <input type="submit" name="btn_search"
											id="btn_search" class="btn_search" value="조회" />
									</form>
								</div>
								<!-- end -->
							</div>
							<div class="panel-body">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th width="10%"><div class="btn btn-default">
													<spring:message code="admin.member.level" />
												</div></th>
											<th width="10%"><div class="btn btn-default">
													<spring:message code="admin.member.name" />
												</div></th>
											<th width="20%"><div class="btn btn-default">
													<spring:message code="admin.member.id" />
												</div></th>
											<th width="15%"><div class="btn btn-default">
													<spring:message code="admin.member.phoneNumber" />
												</div></th>
											<th width="15%"><div class="btn btn-default">
													<spring:message code="admin.member.date" />
												</div></th>
											<th width="10%"><div class="btn btn-default">
													<i class="fa fa-envelope"></i> &nbsp; <i
														class="lnr lnr-highlight"></i>
												</div></th>
											<th width="20%"><a href="#"><button type="button"
														class="btn btn-success">
														<i class="fa fa-check-circle"></i> NEW
													</button></a></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="member" items="${memberList}"
											varStatus="status">
											<tr>
												<td>${member.memberNumber}</td>
												<td width="10%">${member.memberlevel.memberLevelDescription }</td>
												<td width="10%">${member.memberName }</td>
												<td width="20%">${member.memberId }</td>
												<td width="15%">${member.memberPhoneNumber }</td>
												<td width="15%"><fmt:formatDate
														value="${member.memberRegisterDate}" pattern="yyyy-MM-dd" /></td>
												<td width="10%"><form:form
														action="${pageContext.request.contextPath}/admin/messageForm">
														<input type="hidden" name="memberNumber"
															value="${member.memberNumber }">
														<button type="submit" class="btn btn-default">
															<i class="fa fa-plus-square"></i> SEND
														</button>
													</form:form></td>
												<td width="20%"><a href="#"><button type="button"
															class="btn btn-info">
															<i class="lnr lnr-pencil"></i>
														</button></a> &nbsp; <a href="#"><button type="button"
															class="btn btn-danger">
															<i class="fa fa-trash-o"></i>
														</button></a></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<!-- here -->
								<div id="paging" class="paging"
									style="text-align: center; padding-bottom: 20px;"><h4>
									<span class="lnr lnr-arrow-left-circle"></span> &nbsp; <strong>1</strong>
									&nbsp; <span class="lnr lnr-arrow-right-circle"></span></h4>
								</div>
								<!-- end -->
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