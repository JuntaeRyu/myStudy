<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset = "UTF-8">
		<title>main</title>
	</head>
	<body>
		<c:if test="${empty member}">
			<form action="login" method="post">
				<input type="text" name="mid" required> <br>
				<input type="password" name="mpw" required> <br>
				<input type="submit" value="로그인">
			</form>
			<br>
			<a href="mypage">회원가입</a>
		</c:if>
		<c:if test="${not empty member}">
			<a href="mypage">${member}님, 안녕하세요! :D</a> <br>
			<a href="logout">로그아웃</a> <br>
			<a href="insert">글 작성</a>
		</c:if>
		<hr>
		<c:if test="${fn:length(datas) <= 0}">
			<h1>출력할 글이 없습니다.</h1>
		</c:if>
		<c:if test="${fn:length(datas) > 0}">
			<c:forEach var="board" items="${datas}">
				<h3><a href="board/${board.bid}">${board.bid}</a> | ${board.mid}</h3> <br>
			</c:forEach>
		</c:if>
	</body>
</html>