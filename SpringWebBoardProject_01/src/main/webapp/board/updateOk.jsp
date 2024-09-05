<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${bCheck}">
<c:redirect url="detail.do?no=${no}"/>
</c:if>
<c:if test="${!bCheck}">
<script>
alert('비밀번호가 틀립니다 \n다시 입력하세요')
history.back()
</script>
</c:if>