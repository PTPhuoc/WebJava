<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpServletResponse"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page import="com.account.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Dosis:wght@500&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="Style/index.css">
<title>SHOP LINH KIEN</title>
</head>
<body>
<div class="Index">
<%
	ObjectMapper objectMapper = new ObjectMapper();
	Object User = request.getSession().getAttribute("User");
	Account userAccount = (Account) User;
	HttpServletRequest Request = (HttpServletRequest) pageContext.getRequest();
	String Url = Request.getRequestURL().toString();
	if (userAccount != null) {
		if(userAccount.getRole_acc().equals("Admin")){
			%>

	<%@ include file="AdminIndex.jsp"%>

	<%
		}else{
			if (Url.equals("http://localhost:8080/ShopLinhKien/index.jsp") || Url.equals("http://localhost:8080/ShopLinhKien/")) {
				%>

	<%@ include file="Home.jsp"%>

	<%
				} else {
				%>

	<%@ include file="Compoment/SideBar.jsp"%>

	<%
			}
		}
	} else {
		if (Url.equals("http://localhost:8080/ShopLinhKien/index.jsp") || Url.equals("http://localhost:8080/ShopLinhKien/")) {
		%>

		<%@ include file="Home.jsp"%>

		<%
		} else {
		%>

		<%@ include file="Compoment/SideBar.jsp"%>

		<%
		}
	}
		%>
</div>
	
</body>
</html>