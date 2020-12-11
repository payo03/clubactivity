<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<header>
	<div>
		<div class="logo">
			<a href="${pageContext.request.contextPath}/home"><spring:message code="go.main" /></a>
		</div>
		<div>
			<div>
				<c:choose>
					<c:when test="${empty sessionScope.login}">
						<a href="${pageContext.request.contextPath}/login/login"><spring:message code="title.login" /></a>
						<a href="${pageContext.request.contextPath}/signup/step1"><spring:message code="register.member" /></a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/logout"><spring:message code="title.logout" /></a>
						<a href="${pageContext.request.contextPath}/modify"><spring:message code="member.modify" /></a>
						<c:if test="${sessionScope.login.memberlevel.memberLevelCode eq 0}">
							관리자
						</c:if>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	
	<!-- Mobile Menu 
	<div class="col-12">
		<div class="mobile_menu d-block d-lg-none"></div>
		<%-- 모바일 해상도일때 로그인, 로그아웃 회원가입 버튼 보이도록 --%>
		<div class="d-block d-lg-none"
			style="float: right; margin-right: 40px; margin-top: -50px;">
			<c:choose>
				<c:when test="${empty sessionScope.login}">
					<a href="${pageContext.request.contextPath}/login/login"
						class="btn2"
						style="border: none; padding: 5px 15px; text-transform: capitalize; border-radius: 10px; cursor: pointer; color: #fff; display: inline-block; font-size: 10px; transition: 0.6s; box-shadow: 0px 7px 21px 0px rgba(0, 0, 0, 0.12); background-image: linear-gradient(to left, #46C0BE, #6DD56F, #46C0BE); background-position: right; background-size: 200% margin-bottom:100px; margin-top: 12px;"><spring:message
							code="btn.login" /></a>
					<a href="${pageContext.request.contextPath}/signup/step1"
						class="btn2"
						style="border: none; padding: 5px 15px; text-transform: capitalize; border-radius: 10px; cursor: pointer; color: #fff; display: inline-block; font-size: 10px; transition: 0.6s; box-shadow: 0px 7px 21px 0px rgba(0, 0, 0, 0.12); background-image: linear-gradient(to left, #46C0BE, #6DD56F, #46C0BE); background-position: right; background-size: 200% margin-bottom:100px; margin-top: 12px;"><spring:message
							code="register.member" /></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/logout" class="btn2"
						style="border: none; padding: 5px 15px; text-transform: capitalize; border-radius: 10px; cursor: pointer; color: #fff; display: inline-block; font-size: 10px; transition: 0.6s; box-shadow: 0px 7px 21px 0px rgba(0, 0, 0, 0.12); background-image: linear-gradient(to left, #46C0BE, #6DD56F, #46C0BE); background-position: right; background-size: 200% margin-bottom:100px; margin-top: 12px;"><spring:message
							code="title.logout" /></a>
					<c:if test="${sessionScope.login.memberlevel.memberLevelCode eq 0}">
						<a href="${pageContext.request.contextPath}/admin/member/list"><img
							src="${pageContext.request.contextPath}/img/logo/tts.jpg"
							style="max-width: 30px; height: 30px;" alt=""></a>
					</c:if>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	-->
</header>