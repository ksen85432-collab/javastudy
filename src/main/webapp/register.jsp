<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新規登録（サンプル）</title>
</head>
<body>

<h2>新規登録（サンプル）</h2>

<style>
	p{color:red;}
</style>
<%= request.getAttribute("message") == null ? "" : "<p>" + request.getAttribute("message") + "</p>" %>

<form action="RegisterServlet" method="post">
    名前：<br>
    <input type="text" name="name"><br><br>

    メールアドレス：<br>
    <input type="email" name="email"><br><br>

    パスワード：<br>
    <input type="password" name="password"><br><br>

    <input type="submit" value="登録">
</form>

</body>
</html>