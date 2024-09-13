<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row {
	margin: 0px auto;
	width: 1100px;
}
</style>
</head>
<body>
	<center>
		<table border=1 style="border-color: black; width: 1100; height: 700;">
			<tr>
				<td align="center" colspan="2" height="100"><tiles:insertAttribute name="header" /></td>
			</tr>
			<tr>
				<td align="center" height="500" width="300"><tiles:insertAttribute name="nav" /></td>
				<td align="center" height="500" width="800"><tiles:insertAttribute name="content" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2" height="100"><tiles:insertAttribute name="footer" /></td>
			</tr>
		</table>
	</center>

</body>
</html>