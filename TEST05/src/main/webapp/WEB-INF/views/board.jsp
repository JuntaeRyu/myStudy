<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset="UTF-8">
      <title>능단평 게시글</title>
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
         }
         form {
            margin: 20px;
         }
         input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
         }
         input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
         }
         b {
            margin: 10px;
         }
         a {
            text-decoration: none;
            color: #007bff;
         }
      </style>
   </head>
   <body>
      <h1>작성자: ${bdata.mid}</h1>
      <h1>내용: ${bdata.content}</h1>
      <c:if test="${mid eq bdata.mid}">
         <form action="updateBoard" method="post">
            <input type="hidden" name="bid" value="${bdata.bid}">
            <input type="text" name="content" required>
            <input type="submit" value="수정">
         </form>
         <br>
         <b><a href="deleteBoard?bid=${bdata.bid}">삭제</a></b><br>
      </c:if>
      <b><a href="main">메인으로 돌아가기</a></b>
   </body>
</html>
