<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康診断　BMI検索結果</title>
</head>
<body>
<form action="/PracticeServer/HealthCheck" method="post">
<h1>健康診断</h1>
<p>BMIを計算してみよう。<br>身長、体重を入力してください</p>
<p>身長　：<input type="text" name="height">（cm）</p>
<p>体重　：<input type="text" name="weight">（kg）</p>
<input type="submit" value="提出">
</form>
</body>
</html>