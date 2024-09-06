<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>방문한 레시피</h3>
	<a href="../recipe/cookieAll.do" class="btn btn-xs btn-primary">더보기</a>
	<div class="row">
		<c:if test="${size>0}">
			<c:forEach var="rcvo" items="${rcList }" varStatus="i">
				<c:if test="${i.index<6 }">
					<div class="col-sm-2">
						<div class="text-center">
							<div class="thumbnail">
								<a href="../recipe/detailBefore.do?no=${rcvo.no}"><img src="${rcvo.poster}"></a>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</c:if>
		<c:if test="${size==0 }">
			<h3>방문한 레시피가 없습니다</h3>
		</c:if>
	</div>
</body>
</html>