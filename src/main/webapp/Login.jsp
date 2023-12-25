<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/Compoment/Head.jsp"%>
<link rel="stylesheet" href="Style/SignIn.css">
</head>
<body>
	<%
	Object passwordErrObj = request.getSession().getAttribute("Error-Signin-Password");
	Object emailErrObj = request.getSession().getAttribute("Error-Signin-Email");
	String emailErr = (emailErrObj != null) ? emailErrObj.toString() : "";
	String passwordErr = (passwordErrObj != null) ? passwordErrObj.toString() : "";
	%>
	<img class="Login-BR" src="Image/BRLogin.png">
	<form class="Login-Form" action="Login" method="post">
		<div class="LF-All">
			<div class="LF-Action-BR">
				<div class="LF-Action">
					<div class="LF-Title">
						<h3>LOGIN</h3>
					</div>
					<div class="LF-Email">
						<input class="<%=emailErr%>" type="email" name="email"
							placeholder="Email">
					</div>
					<div class="LF-Pass">
						<input class="<%=passwordErr%>" type="password" name="password" placeholder="Password">
					</div>
					<div class="LF-B-Submit">
						<button type="submit">CONFIRM</button>
					</div>
					<div class="LF-Link">
						<a href="#">Quên Mật Khẩu!</a><br>
						<hr>
						<a href="SignUp.jsp">Bạn chưa có tài khoản!</a>
					</div>
				</div>
				<div class="LF-Image">
					<img class="LFI" src="Image/LoginLeft.png">
				</div>
			</div>

		</div>
	</form>
</body>
</html>