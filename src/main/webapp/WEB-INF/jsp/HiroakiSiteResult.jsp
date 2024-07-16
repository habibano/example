<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="beans.Questionnaire" %>
<%  ServletContext applicaiton = this.getServletContext();%>
<%  Questionnaire q = (Questionnaire) applicaiton.getAttribute("questionnaire"); %>

<%  int dogCnt = q.getDogCnt(); %>
<%  int catCnt = q.getCatCnt(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>こんにちは</h1>
<p>アンケート：あなたは犬派か猫派か</p>
<p>アンケート結果：</p>
<a>犬派</a>
<p>投票数：<%= dogCnt %></p>
<a>猫派</a>
<p>投票数：<%= catCnt %></p>
</body>
</html>