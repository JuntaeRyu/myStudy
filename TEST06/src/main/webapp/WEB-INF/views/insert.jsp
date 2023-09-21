<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset = "UTF-8">
		<title>insert</title>
	</head>
	<body>
		<form action="insert" method="post">
			<input type="text" name="mid" readonly value="${member}"> <br>
			<input type="text" name="content" required> <br>
			<input type="submit" value="글 작성">
		</form>
		<hr>
		<a href="/">메인으로 돌아가기</a>
	</body>
</html>