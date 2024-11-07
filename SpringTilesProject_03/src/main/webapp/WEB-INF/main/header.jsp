<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="top_header_area">
		<div class="container">
			<div class="row">
				<div class="col-5 col-sm-6">
					<!--  Top Social bar start -->
					<div class="top_social_bar">
						<a href="#">
							<i class="fa fa-facebook" aria-hidden="true"></i>
						</a>
						<a href="#">
							<i class="fa fa-twitter" aria-hidden="true"></i>
						</a>
						<a href="#">
							<i class="fa fa-linkedin" aria-hidden="true"></i>
						</a>
						<a href="#">
							<i class="fa fa-skype" aria-hidden="true"></i>
						</a>
						<a href="#">
							<i class="fa fa-dribbble" aria-hidden="true"></i>
						</a>
					</div>
				</div>
				<!--  Login Register Area -->
				<div class="col-7 col-sm-6">
					<div class="signup-search-area d-flex align-items-center justify-content-end">
						<div class="login_register_area d-flex">
							<c:if test="${sessionScope.id==null}">
								<div class="login">
									<a href="../member/login.do">Sing in</a>
								</div>
								<div class="register">
									<a href="register.html">Sing up</a>
								</div>
							</c:if>
							<c:if test="${sessionScope.id!=null}">
								<div class="login">
									<a>${sessionScope.name}</a>
								</div>
								<div class="register">
									<a href="../member/logout.do">Logout</a>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ****** Top Header Area End ****** -->

	<!-- ****** Header Area Start ****** -->
	<header class="header_area">
		<div class="container">
			<div class="row">
				<!-- Logo Area Start -->
				<div class="col-12">
					<div class="logo_area text-center">
						<a href="index.html" class="yummy-logo">Yummy Blog</a>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<nav class="navbar navbar-expand-lg">
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#yummyfood-nav" aria-controls="yummyfood-nav"
							aria-expanded="false" aria-label="Toggle navigation">
							<i class="fa fa-bars" aria-hidden="true"></i> Menu
						</button>
						<!-- Menu Area Start -->
						<div class="collapse navbar-collapse justify-content-center" id="yummyfood-nav">
							<ul class="navbar-nav" id="yummy-nav">
								<li class="nav-item active">
									<a class="nav-link" href="../main/main.do">
										Home <span class="sr-only">(current)</span>
									</a>
								</li>
								<li class="nav-item dropdown">
									<a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">회원</a>
									<div class="dropdown-menu" aria-labelledby="yummyDropdown">
										<a class="dropdown-item" href="index.html">회원가입</a>
										<a class="dropdown-item" href="archive.html">아이디찾기</a>
										<a class="dropdown-item" href="contact.html">비밀번호찾기</a>
									</div>
								</li>
								<li class="nav-item dropdown">
									<a class="nav-link dropdown-toggle" href="#" id="yummyDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">레시피</a>
									<div class="dropdown-menu" aria-labelledby="yummyDropdown">
										<a class="dropdown-item" href="../recipe/recipeList.do">레시피</a>
										<a class="dropdown-item" href="../recioe/chefList.do">쉐프</a>
										<a class="dropdown-item" href="contact.html">레시피만들기</a>
									</div>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#">Features</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#">Categories</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="archive.html">Archive</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#">About</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="contact.html">Contact</a>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header>
</body>
</html>