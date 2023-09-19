<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>능단평 마이페이지</title>
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

        a {
            text-decoration: none;
            color: #007bff;
            margin: 10px;
            display: block;
        }
    </style>
</head>
<body>
<h1>${mdata.mid}님의 마이페이지!!</h1>
<form action="updateMpw" method="post">
    <input type="hidden" name="mid" value="${mdata.mid}">
    <input type="password" name="mpw" required>
    <input type="submit" value="비밀번호 변경">
</form>
<a href="javascript:void(0);" onclick="confirmDelete('${mdata.mid}')">회원탈퇴</a>
<a href="main">메인으로 돌아가기</a>

<script>
    function confirmDelete(mid) {
        if (confirm("회원 탈퇴하시겠습니까???? ㅠㅠㅠㅠㅠ")) {
            window.location.href = "deleteMember?mid="+mid;
        }
    }
</script>
</body>
</html>
