<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>

	<h2>ログイン</h2>
	
	<style>
	p{color:red;}
	</style>
	<%=request.getAttribute("message") == null ? "" : "<p>" + request.getAttribute("message") + "</p>"%>

	<form action="LoginServlet" method="post">
		メールアドレス：<br> <input type="email" name="email"><br>
		<br> パスワード：<br> <input type="password" name="password"><br>
		<br> <input type="submit" value="ログイン">
	</form>

	<a href="index.jsp">トップへ戻る</a>

</body>
</html>
