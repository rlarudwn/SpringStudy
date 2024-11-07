<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="../img/core-img/favicon.ico">
<link href="../style.css" rel="stylesheet">
<link href="../css/responsive/responsive.css" rel="stylesheet">
</head>
<body>
	<div id="pattern-switcher">Bg Pattern</div>
	<div id="patter-close">
		<i class="fa fa-times" aria-hidden="true"></i>
	</div>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="home" />
	<tiles:insertAttribute name="footer" />
	<script src="../js/jquery/jquery-2.2.4.min.js"></script>
	<script src="../js/bootstrap/popper.min.js"></script>
	<script src="../js/bootstrap/bootstrap.min.js"></script>
	<script src="../js/others/plugins.js"></script>
	<script src="../js/active.js"></script>
</body>
</html>