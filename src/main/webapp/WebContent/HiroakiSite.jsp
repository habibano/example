<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>こんにちは</h1>
<p>アンケート：あなたは犬派か猫派か</p>
<form action="/PracticeServer/HiroakiSiteControl" method="get">
<a href="/PracticeServer/HiroakiSiteControl?action=dog">犬派</a>
<p>投票数：???</p>
<a href="/PracticeServer/HiroakiSiteControl?action=cat">猫派</a>
<p>投票数：???</p>
</form>
</body>
</html>