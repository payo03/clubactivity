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
					<div class="panel panel-profile">
						<div class="clearfix">
							<!-- LEFT COLUMN -->
							<div class="profile-left">
								<!-- PROFILE HEADER -->
								<div class="profile-header">
									<div class="overlay"></div>
									<div class="profile-main">
										<a
											href="${pageContext.request.contextPath }/edit/uploadImage/${sessionScope.login.memberNumber}">
											<img class="img-circle" width="75" height="75"
											src="${pageContext.request.contextPath}/upload/${sessionScope.login.image.imagePath}">
										</a>
										<h3 class="name">${sessionScope.login.memberName }</h3>
										<c:choose>
											<c:when
												test="${sessionScope.login.memberonline.memberStatus }">
												<a href="#" class="notification-item"><span
													class="dot bg-success"></span>Online</a>
											</c:when>
											<c:otherwise>
												<a href="#" class="notification-item"><span
													class="dot bg-warning"></span>Clocking</a>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
								<!-- END PROFILE HEADER -->
								<!-- PROFILE DETAIL -->
								<div class="profile-detail">
									<div class="profile-info">
										<h4 class="heading">Basic Info</h4>
										<ul class="list-unstyled list-justify">
											<li>Registration Date <span><fmt:formatDate
														value="${sessionScope.login.memberRegisterDate}"
														pattern="yyyy-MM-dd" /></span></li>

											<li>Email <span>${sessionScope.login.memberId } <a
													href="${pageContext.request.contextPath }/edit/updateId"><i
														class="lnr lnr-pencil"></i></a></span></li>

											<li>Mobile <span>${sessionScope.login.memberPhoneNumber }
													<a
													href="${pageContext.request.contextPath }/edit/updatePhoneNumber"><i
														class="lnr lnr-pencil"></i></a>
											</span></li>

											<li>Website <span><a
													href="${sessionScope.login.memberWebsite }">${sessionScope.login.memberWebsite }
												</a><a
													href="${pageContext.request.contextPath }/edit/updateWebsite"><i
														class="lnr lnr-pencil"></i></a></span></li>
										</ul>
									</div>
									<div class="profile-info">
										<h4 class="heading">Social</h4>
										<ul class="list-inline social-icons">
											<li><a
												href="https://www.facebook.com/profile.php?id=100034820436628"
												class="facebook-bg"><i class="fa fa-facebook"></i></a></li>
											<li><a href="https://github.com/payo03"
												class="github-bg"><i class="fa fa-github"></i></a></li>
										</ul>
									</div>
								</div>
								<!-- END PROFILE DETAIL -->
							</div>
							<!-- END LEFT COLUMN -->

							<!-- RIGHT COLUMN -->
							<div class="profile-right">
								<h4 class="heading">Update Profile</h4>
								<!-- Profile Update Form -->
								<div class="awards">
									<div class="row">

										<!-- Image Update -->
										<c:choose>
											<c:when test="${!empty uploadImage }">
												<c:if test="${empty modifyImage}">
													<form id="form" method="post" enctype="multipart/form-data"
														action="${pageContext.request.contextPath}/edit/uploadImage">
														<label for="ex_file"> <a class="btn btn-info"
															style="color: white;">Image Upload</a>
														</label> <input type="file" multiple="multiple" name="file"
															style="display: none" id="ex_file" /> <input
															type="hidden" name="memberNumber"
															value="${sessionScope.login.memberNumber}" /> &nbsp;
														<button type="submit" name="select" value="true"
															class="btn btn-success">Select</button>
														<button type="submit" name="delete" value="true"
															class="btn btn-danger">Delete</button>
													</form>
													<br>
													<c:forEach var="image" items="${imageList}"
														varStatus="status">
														<div class="col-md-3 col-sm-6">
															<div class="award-item">
																<div class="profile-main">
																	<a
																		href="${pageContext.request.contextPath}/upload/${image.imagePath}"
																		class="img-circle"> <img width="125" height="125"
																		class="img-circle"
																		src="<spring:url value='/upload/${image.imagePath}'/>" />
																	</a>
																</div>
															</div>
														</div>
													</c:forEach>
												</c:if>

												<c:if test="${modifyImage eq true}">
													<form:form method="post"
														action="${pageContext.request.contextPath}/edit/updateImage/${sessionScope.login.memberNumber}">
														<button type="submit" class="btn btn-success">Select</button>
														&nbsp; <a
															href="${pageContext.request.contextPath}/profile/refresh">
															<button type="button" class="btn btn-danger">Cancel</button>
														</a>
														<br>
														<br>
														<c:forEach var="image" items="${imageList}"
															varStatus="status">
															<div class="col-md-3 col-sm-6">
																<div class="award-item">
																	<div class="profile-main">
																		<a
																			href="${pageContext.request.contextPath}/upload/${image.imagePath}"
																			class="img-circle"> <img width="125" height="125"
																			class="img-circle"
																			src="<spring:url value='/upload/${image.imagePath}'/>" />
																		</a>
																		<div class="checkBox">
																			<input type="radio" name="radio"
																				value="${image.imagePath}" />
																		</div>
																	</div>
																</div>
															</div>
														</c:forEach>
													</form:form>
												</c:if>

												<c:if test="${modifyImage eq false}">
													<form:form method="post"
														action="${pageContext.request.contextPath}/edit/deleteImage/${sessionScope.login.memberNumber}">
														<button type="submit" class="btn btn-success">Delete</button>
														&nbsp; <a
															href="${pageContext.request.contextPath}/profile/refresh">
															<button type="button" class="btn btn-danger">Cancel</button>
														</a>
														<br>
														<br>
														<c:forEach var="image" items="${imageList}"
															varStatus="status">
															<div class="col-md-3 col-sm-6">
																<div class="award-item">
																	<div class="profile-main">
																		<a
																			href="${pageContext.request.contextPath}/upload/${image.imagePath}"
																			class="img-circle"> <img width="125" height="125"
																			class="img-circle"
																			src="<spring:url value='/upload/${image.imagePath}'/>" />
																		</a>
																		<div class="checkBox">
																			<input type="checkbox" name="checkbox"
																				value="${image.imagePath}" />
																		</div>
																	</div>
																</div>
															</div>
														</c:forEach>
													</form:form>
												</c:if>

											</c:when>

											<c:when test="${!empty updateId }">

											</c:when>

											<c:when test="${!empty updatePhoneNumber }">
												<div class="btn btn-default">Mobile Update</div>
												<br>
												<br>
												<form:form
													action="${pageContext.request.contextPath }/edit/updatePhoneNumber"
													modelAttribute="changeNumberCommand"
													class="form-auth-small">
													<div class="input-group">
														<form:input path="memberPhoneNumber"
															value="${sessionScope.login.memberPhoneNumber }"
															onKeyup="inputPhoneNumber(this);" maxlength="13"
															pattern=".{13,13}" class="form-control" />
														<input type="hidden" name="memberNumber"
															value="${sessionScope.login.memberNumber }" /> <span
															class="input-group-btn">
															<button type="submit" class="btn btn-success">Update</button>
															&nbsp; <a
															href="${pageContext.request.contextPath}/profile/refresh">
																<button type="button" class="btn btn-danger">Cancel</button>
														</a>
														</span>
													</div>
													<form:errors path="memberPhoneNumber" />
												</form:form>
											</c:when>

											<c:when test="${!empty updateWebsite }">
												<div class="btn btn-default">Website Update</div>
												<br>
												<br>
												<form:form
													action="${pageContext.request.contextPath }/edit/updateWebsite"
													modelAttribute="changeWebsiteCommand"
													class="form-auth-small">
													<textarea name="memberWebsite" class="form-control"
														rows="3" placeholder="https://...">${sessionScope.login.memberWebsite }</textarea>
													<input type="hidden" name="memberNumber"
														value="${sessionScope.login.memberNumber }" />
													<span class="input-group-btn">
														<button type="submit" class="btn btn-success">Update</button>
														&nbsp; <a
														href="${pageContext.request.contextPath}/profile/refresh">
															<button type="button" class="btn btn-danger">Cancel</button>
													</a>
													</span>
													<form:errors path="memberWebsite" />
												</form:form>
											</c:when>
										</c:choose>
										<br>
									</div>
									<div class="text-center">
										<a href="${pageContext.request.contextPath}/edit/status">
											<c:choose>
												<c:when
													test="${sessionScope.login.memberonline.memberStatus }">
													<button class="btn label-default">Clocking</button>
												</c:when>
												<c:otherwise>
													<button class="btn label-success">Online</button>
												</c:otherwise>
											</c:choose>
										</a>
									</div>
								</div>
								<!-- END AWARDS -->
								<!-- TABBED CONTENT -->
								<div class="custom-tabs-line tabs-line-bottom left-aligned">
									<ul class="nav" role="tablist">
										<li class="active"><a href="#tab-bottom-left" role="tab"
											data-toggle="tab">Notifications History</a></li>
										<li><a href="#tab-bottom-right" role="tab"
											data-toggle="tab">Find Friends</a></li>
									</ul>
								</div>
								<div class="tab-content">
									<div class="tab-pane fade in active" id="tab-bottom-left">
										<ul class="list-unstyled activity-timeline">
											<li><i class="fa fa-comment activity-icon"></i>
												<p>
													Commented on post <a href="#">Prototyping</a> <span
														class="timestamp">2 minutes ago</span>
												</p></li>
											<li><i class="fa fa-cloud-upload activity-icon"></i>
												<p>
													Uploaded new file <a href="#">Proposal.docx</a> to project
													<a href="#">New Year Campaign</a> <span class="timestamp">7
														hours ago</span>
												</p></li>
											<li><i class="fa fa-plus activity-icon"></i>
												<p>
													Added <a href="#">Martin</a> and <a href="#">3 others
														colleagues</a> to project repository <span class="timestamp">Yesterday</span>
												</p></li>
											<li><i class="fa fa-check activity-icon"></i>
												<p>
													Finished 80% of all <a href="#">assigned tasks</a> <span
														class="timestamp">1 day ago</span>
												</p></li>
										</ul>
										<div class="margin-top-30 text-center">
											<a href="#" class="btn btn-default">See all Notifications</a>
										</div>
									</div>
									<div class="tab-pane fade" id="tab-bottom-right">
										<div class="table-responsive">
											<div class="col-md-12 text-right">
												<a href="${pageContext.request.contextPath}/profile/refresh">
													<button type="button" class="btn btn-primary">
														<i class="fa fa-refresh"></i>
													</button>
												</a>
											</div>
											<table class="table table-striped">
												<thead>
													<tr>
														<th width="10%"><div class="btn btn-default">
																<spring:message code="name" />
															</div></th>
														<th width="20%"><div class="btn btn-default">
																<spring:message code="memberId" />
															</div></th>
														<th width="10%"><div class="btn btn-default">
																<i class="fa fa-envelope"></i> &nbsp; <i
																	class="lnr lnr-highlight"></i>
															</div></th>
														<th width="3%"><div class="btn btn-default">
																<spring:message code="memberonline" />
															</div></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="member" items="${memberList}"
														varStatus="status">
														<tr>
															<td width="10%">${member.memberName }</td>
															<td width="20%">${member.memberId }</td>
															<td width="10%"><form:form action="#">
																	<input type="hidden" name="memberNumber"
																		value="${member.memberNumber }">
																	<button type="submit" class="btn btn-default">
																		<i class="fa fa-plus-square"></i> SEND
																	</button>
																</form:form></td>
															<td width="3%"><c:choose>
																	<c:when test="${member.memberonline.memberStatus }">
																		<a href="#" class="notification-item"><span
																			class="dot bg-success"></span>Online</a>
																	</c:when>
																	<c:otherwise>
																		<a class="notification-item"><span
																			class="dot bg-warning"></span>Offline</a>
																	</c:otherwise>
																</c:choose></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<!-- END TABBED CONTENT -->
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
<script defer type="text/javascript">
	document.getElementById("ex_file").onchange = function() {
		document.getElementById("form").submit();
	};
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