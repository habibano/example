<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録画面</title>
</head>
<body>
<form action="/PracticeServer/RegisterUser" method="post">
<p>ユーザ登録
<p>ログインID：<input type="text" name="id"></p>
<p>パスワード：<input type="password" name="password"></p>
<p>氏　　　名：<input type="name" name="name"></p>
<input type="submit" value="送信">
</form>
</body>
</html>