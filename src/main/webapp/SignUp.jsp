<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/Compoment/Head.jsp"%>
<link rel="stylesheet" href="Style/SignUp.css">
</head>
<body>
	<img class="SignUp-BR" src="Image/BRLogin.png">
	<form class="SignUp-Form" action="SignUp" method="post">
		<div class="SF-All">
			<div class="SF-Action-BR">
				<div class="SF-Action">
					<div class="SF-Title">
						<h3>SIGN UP</h3>
					</div>
					<% 
						Object emailObj = request.getAttribute("email");
						Object nameObj = request.getAttribute("name");
						Object passwordErrObj = request.getSession().getAttribute("Error-Signin-Password");
						Object emailErrObj = request.getSession().getAttribute("Error-Signin-Email");
						String emailErr = (emailErrObj != null) ? emailErrObj.toString() : "";
						String passwordErr = (passwordErrObj != null) ? passwordErrObj.toString() : "";
					  	String email = (emailObj != null) ? emailObj.toString() : "";
					   	String name = (nameObj != null) ? nameObj.toString() : "";
					   	if(email != ""){
					   		request.getSession().setAttribute("Status-SignIn", "Disable");
					   	}else{
					   		request.getSession().setAttribute("Status-SignIn", "Enable");
					   	}
					   	if(emailErr.equals("Error-Email")){
					   		request.getSession().setAttribute("Status-SignIn", "Enable");
					   	}
					%>
					<div>
						<input type="text" placeholder="Tên Tài Khoản" name="name" value="<%= name %>">
					</div>
					<div class="SF-Email">
						<input type="email" id="<%= emailErr %>" class="<%= request.getSession().getAttribute("Status-SignIn") %>" placeholder="Email" name="email" value="<%= email %>">
					</div>
					<div class="SF-Pass">
						<input type="password" class="<%= passwordErr %>" name="password" placeholder="Mật Khẩu">
					</div>
					<div class="SF-Pass">
						<input type="password" class="<%= passwordErr %>" name="repassword" placeholder="Xác Nhận Mật Khẩu">
					</div>
					<div class="SF-B-Submit">
						<button type="submit">CONFIRM</button>
					</div>
					<div class="SF-Line"></div>
					<div class="SF-Link" >
						<a class="<%= request.getSession().getAttribute("Status-SignIn") %>" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/ShopLinhKien/SignIn-Google&response_type=code
    						&client_id=200588205858-6p7j3r61fsv4k8je3o4h7p2psh1bder3.apps.googleusercontent.com&approval_prompt=force">
							<div>
								<i class="fa-brands fa-google"></i>
							</div>
							<div>
								<p>Đăng ký với GOOGLE</p>
							</div>
						</a>
					</div>
				</div>
				<div class="SF-Image">
					<img src="Image/LoginLeft.png">
				</div>
			</div>
		</div>
	</form>
	<script src="https://kit.fontawesome.com/489bd3f8d2.js"
		crossorigin="anonymous"></script>
</body>
</html>