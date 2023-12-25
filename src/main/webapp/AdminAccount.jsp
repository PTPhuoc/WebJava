<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page import="com.account.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/Compoment/Head.jsp"%>
<link rel="stylesheet" href="Style/AdminIndex.css">
<link rel="stylesheet" href="Style/AdminAccount.css">
<title>ADMIN ACCOUNT</title>
</head>
<body>
	<div class="AdminIndex"
		id="<%=request.getSession().getAttribute("StatusPageAdminAccount")%>">
		<div class="AI-Top">
			<div>
				<h3>ADMIN MODE</h3>
			</div>
			<div>
				<a href="LogOut">LOG OUT</a>
			</div>
		</div>
		<div class="AI-Bottom">
			<div class="AI-Left">
				<div>
					<a href="AdminAccount.jsp">ACCOUNT</a>
				</div>
				<div>
					<a href="AdminProductList.jsp">PRODUCT LIST</a>
				</div>
			</div>
			<div class="AA-Right">
				<div class="AA-Title">
					<h3>ACCOUNT</h3>
				</div>
				<div>
					<div class="AA-Line"></div>
				</div>
				<div class="AA-Table">

					<table>
						<tr>
							<th>Email</th>
							<th>Name</th>
							<th>Role</th>
							<th>Money</th>
							<th>Date Create</th>
							<th>Edit</th>
						</tr>
						<%
						DecimalFormat df = new DecimalFormat("###,###,###.0");
						ShowAllAccount SA = new ShowAllAccount();
						List<Account> AccList = SA.GetAllAccount();
						if (!AccList.isEmpty()) {
							for (Account acc : AccList) {
						%>
						<tr>
							<td><%=acc.getEmail_acc()%></td>
							<td><%=acc.getName_acc()%></td>
							<td><%=acc.getRole_acc()%></td>
							<td><%=df.format(acc.getMoney_acc())%></td>
							<td><%=acc.getDate_create_acc()%></td>
							<td class="AA-Edit">
								<div>
									<a href="EnableEditAccount?email=<%=acc.getEmail_acc()%>"><i
										class="fa-solid fa-pen-to-square"></i></a>
								</div>
								<div>
									<a
										href="EnableConfirmDeleteAccount?email=<%=acc.getEmail_acc()%>"><i
										class="fa-solid fa-trash"></i></a>
								</div>
							</td>
						</tr>
						<%
						}
						} else {
						%>
						<tr>
							<td>EMPTY</td>
						</tr>
						<%
						}
						%>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div
		class="<%=request.getSession().getAttribute("StatusEditAccount")%>">
		<%
		Object EditAccObj = request.getSession().getAttribute("EditAccount");
		if (EditAccObj != null) {
			Account EditAcc = (Account) EditAccObj;
		%>
		<div class="AAE-BR">
			<div class="AAE-Title">
				<h3>
					EDIT ACCOUNT
					<%=EditAcc.getEmail_acc()%></h3>
			</div>
			<div class="AAE-Center">
				<form class="AAE-C-Form" action="EditAccount" method="post">
					<div class="AAE-C-Action">
						<div>
							<h2>Name</h2>
						</div>
						<div>
							<input type="text" name="name" value="<%=EditAcc.getName_acc()%>">
						</div>
					</div>
					<div class="AAE-C-Action">
						<div>
							<h2>Role</h2>
						</div>
						<div>
							<input type="text" name="role" value="<%=EditAcc.getRole_acc()%>">
						</div>
					</div>
					<div class="AAE-C-Action">
						<div>
							<h2>Money</h2>
						</div>
						<div>
							<input
								class="<%if(request.getSession().getAttribute("ErrorEditMoney") == null ){ out.print("NoError"); }else{ out.print(request.getSession().getAttribute("ErrorEditMoney").toString()); }%>"
								type="text" name="money"
								value="<%=df.format(EditAcc.getMoney_acc())%>">
						</div>
					</div>
					<div class="AAE-Bottom">
						<div>
							<button type="submit">XÁC NHẬN</button>
						</div>
						<div>
							<button
								onclick="window.location='<%=request.getContextPath()%>/DisableEditAccount'">HỦY</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<%
		}
		%>
	</div>
	<div class="<%= request.getSession().getAttribute("StatusConfirmAccount")%>">
		<div class="AAE-D-BR">
			<div class="AAE-D-Infor">
				<i class="fa-solid fa-circle-info"></i>
			</div>
			<div class="AAE-D-Content">
				<p>
					Bạn có chắc là muốn xóa tài khoản<br /><%=request.getSession().getAttribute("DeleteEmail")%></p>
			</div>
			<div class="AAE-D-Button">
				<div>
					<button onclick="window.location='<%=request.getContextPath()%>/DeleteAccount?email=<%= request.getSession().getAttribute("DeleteEmail")%>'">XÁC NHẬN</button>
				</div>
				<div>
					<button onclick="window.location='<%=request.getContextPath()%>/DisableConfirmDeleteAccount'">HỦY</button>
				</div>
			</div>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/489bd3f8d2.js"
						crossorigin="anonymous"></script>
</body>
</html>