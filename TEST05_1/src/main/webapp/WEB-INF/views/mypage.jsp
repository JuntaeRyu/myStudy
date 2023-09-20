<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset = "UTF-8">
		<title>mypage</title>
	</head>
	<body>
		<c:if test="${empty member}">
			<form action="join" method="post">
				<input type="text" name="mid" required> <br>
				<input type="password" name="mpw" required> <br>
				<input type="submit" value="회원가입">
			</form>
		</c:if>
		<c:if test="${not empty member}">
			<form action="mypage" method="post">
				<input type="text" name="mid" readonly value=${member}> <br>
				<input type="password" name="mpw" required> <br>
				<input type="submit" value="회원정보변경">
			</form>
			<br>
			<a href="deleteAccount/${member}">회원탈퇴</a>
		</c:if>
		<hr>
		<a href="/">메인으로 돌아가기</a>
	</body>
</html>