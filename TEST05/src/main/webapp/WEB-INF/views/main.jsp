<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>능단평 메인</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        h1 {
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            margin-top: 0;
        }

        form {
            margin: 20px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        b {
            margin: 10px 0;
            display: block;
        }

        hr {
            border: 1px solid #ccc;
            margin: 20px 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        a {
            text-decoration: none;
            color: #007bff;
            margin: 10px 0;
            display: block;
        }
    </style>
</head>
<body>
<c:if test="${empty mid}">
    <h1>회원가입</h1>
    <form action="signup" method="post">
        <input type="text" name="mid" required>
        <input type="password" name="mpw" required>
        <input type="submit" value="회원가입">
    </form>

    <hr>

    <h1>로그인</h1>
    <form action="login" method="post">
        <input type="text" name="mid" required>
        <input type="password" name="mpw" required>
        <input type="submit" value="로그인">
    </form>
</c:if>

<c:if test="${not empty mid}">
    <b><a href="mypage">마이페이지</a></b>
    <b><a href="logout">로그아웃</a></b>
    <hr>
    <form action="insertBoard" method="post">
        <input type="hidden" name="mid" value="${mid}">
        <input type="text" name="content" required>
        <input type="submit" value="게시글 작성">
    </form>
    <c:if test="${empty bdatas}">
        <h1>현재 게시글이 없습니다</h1>
    </c:if>
    <c:if test="${not empty bdatas}">
        <table>
            <thead>
            <tr>
                <th>글 번호</th>
                <th>작성자</th>
                <th>게시글</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="v" items="${bdatas}">
                <tr>
                    <td><a href="board?bid=${v.bid}">${v.bid}</a></td>
                    <td>${v.mid}</td>
                    <td>${v.content}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</c:if>
</body>
</html>
