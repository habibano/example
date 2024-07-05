<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.User" %>
<%  User user = (User) session.getAttribute("user");%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録確認画面</title>
</head>
<body>
<form action="/PracticeServer/RegisterUser" method="get">
<p>以下の内容でユーザ登録します
<p>ログインID：<%= user.getId() %></p>
<p>パスワード：※セキュリティのため表示されません</p>
<p>氏　　　名：<%= user.getName() %></p>

<%--doGETの場合は<a>タグを使うことで隠しパラメータを引き渡すことが可能 --%>
<a href="/PracticeServer/RegisterUser">戻る</a>
<a href="/PracticeServer/RegisterUser?action=done">登録</a>

</form>
</body>
</html>