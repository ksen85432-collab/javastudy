<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ミニ掲示板</title>
</head>
<body>

<h2>ミニ掲示板</h2>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
%>
    <a href="login.jsp">ログイン</a><br>
    <a href="register.jsp">新規登録</a>
<%
    } else {
%>
    <p><%= user.getName() %> さん、こんにちは！</p>
    <a href="boardServlet">掲示板へ</a><br>
    <a href="LogoutServlet">ログアウト</a>
<%
    }
%>

</body>
</html>
