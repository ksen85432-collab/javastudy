<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>掲示板ページ</h2>

<%
	User user = (User) session.getAttribute("user");
%>
    <p> <%= user.getName() %> さん、こんにちは！</p>
    <a href="LogoutServlet">ログアウト</a>
    <br>
    
    <br>
    <b>新規投稿ファーム</b>
    <form action="PostServlet" method="post">
    	投稿内容（200文字まで）：<br>
    	<style>
  	.fixed-textarea {
    resize: none;      /* サイズ変更を禁止 */
    width: 400px;      /* 横幅を固定 */
    height: 100px;     /* 高さを固定 */
  	}
	</style>
	 <textarea class="fixed-textarea" id="t_message" name="message" placeholder="投稿内容入力ボックス（改行可能）">
	</textarea><br>
	<input type="submit" value="投稿"><br>
	</form>
	<br>
	
	<b>投稿一覧（新しい順）</b>
	 <c:forEach var="msg" items="${postdate}">
     	<article >
     		<div >
     		<span >[ ${msg.getName()} ]</span>
     		<span ><c:out value="${msg.getCreatedAt()}" /></span><br>
     		<span >${msg.getContent()}</span>
     		</div>
     		<br>                       
     	</article>
     </c:forEach>
</body>
</html>