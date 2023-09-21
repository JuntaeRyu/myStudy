<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset = "UTF-8">
		<title>board</title>
	</head>
	<body>
		<form action="/update" method="post">
			<input type="hidden" name="bid" value="${board.bid}">
			<input type="text" name="mid" readonly value="${board.mid}"> <br>
			<input type="text" name="content" required value="${board.content}"> <br>
			<c:if test="${member eq board.mid}">
				<input type="submit" value="글 변경">
			</c:if>
		</form>
		<br>
		<c:if test="${member eq board.mid}">
			<a href="/delete/${board.bid}">글 삭제</a>
		</c:if>	
		<hr>
		<a href="/">메인으로 돌아가기</a>
	</body>
</html>