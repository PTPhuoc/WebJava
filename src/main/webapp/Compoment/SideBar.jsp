<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page import="com.account.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Style/TaskBar.css">
</head>
<body>

	<div class="SideBar">
		<div class="SB-Title">
			<a class="SB-Link" href="Home.jsp"><span class="SB-First">PUSEN</span><span
				class="SB-Last">SHOP</span></a>
		</div>
		<div class="SB-Action">
			<div class="SBA-Home">
				<a href="Home.jsp" class="SBA-Link">HOME</a>
			</div>
			<div class="SBA-Store">
				<a href="Store.jsp" class="SBA-Link">STORE</a>
			</div>
			<%
			ObjectMapper OjM = new ObjectMapper();
			Object UserOj = request.getSession().getAttribute("User");
			if (UserOj != null) {
				Account userAcc = (Account) UserOj;
				String Name = userAcc.getName_acc();
			%>
			<div class="SBA-Account">
				<a href="Account.jsp"><%=Name%></a>
			</div>
			
			<div class="SBA-LogOut">
				<a  href="LogOut">LOG OUT</a>
			</div>
			<%
			}else{
			%>
			<div class="SBA-Login">
				<a href="Login.jsp" class="SBA-Link">LOGIN</a>
			</div>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>