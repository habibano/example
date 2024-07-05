<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.Health" %>
<%double height = 0; %>
<%double weight = 0; %>
<%double bmi = 0; %>
<%String bodyType =""; %>
<%Health health = (Health)request.getAttribute("health"); %>
<%height = health.getHeight(); %>
<%weight = health.getWeight(); %>
<%bmi = health.getBmi(); %>
<%bodyType = health.getBodyType(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康診断結果</title>
</head>
<body>
<h1>健康診断</h1>
<p>あなたのBMIの計算結果が出ました<br></p>
<p>身長　：<%= height %>（cm）</p>
<p>体重　：<%= weight %>（kg）</p>
<p>ＢＭＩ：<%= bmi %></p>
<p>体型　：<%= bodyType%></p>
</body>
</html>