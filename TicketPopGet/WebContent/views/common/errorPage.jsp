<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String errorMsg = (String)request.getAttribute("errorMsg");  //reqeust : jsp 내장객체라서 바로 접근 가능
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center" style="color:red"><%= errorMsg %></h1>

    <div align="center">
        <button onclick="history.back();">이전페이지로</button>
        <button onclick="location.href='<%= request.getContextPath() %>'">메인페이지로</button> 
    </div>
</body>
</html>