<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.inventory.*"%>
<%@page import="com.account.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/Compoment/Head.jsp"%>
<link rel="stylesheet" href="Style/Store.css">
<link rel="stylesheet" href="Style/Account.css">
</head>
<body>
	<div class="Account-SideBar">
		<%@ include file="/Compoment/SideBar.jsp"%>
	</div>
	<div class="Account">
		<div class="Account-Infor">
			<div class="Account-Image">
				<img alt="User.png" src="Image/User.png">
			</div>
			<div class="Account-Text">
				<%
					Object UserObj = request.getSession().getAttribute("User");
					DecimalFormat df = new DecimalFormat("###,###,###.0");
					Account User = (Account) UserObj;
				%>
				<div>
					<div><h4>Tên: </h4></div>
					<div><p><%= User.getName_acc() %></p></div>
				</div>
				<div>
					<div><h4>Email: </h4></div>
					<div><p><%= User.getEmail_acc() %></p></div>
				</div>
				<div>
					<div><h4>Số Tiền: </h4></div>
					<div><p><%= df.format(User.getMoney_acc()) %> VND</p></div>
				</div>
			</div>
		</div>
		<div class="Account-Cart">
			<div class="AC-Title">
				<div>
					<h4>Giỏ Hàng</h4>
				</div>
				<div>
					<a href="BuyCart?Email=<%= User.getEmail_acc() %>">Mua</a>
				</div>
			</div>
			<div class="AC-Table">
				<table>
					<tr>
						<th>Tên</th>
						<th>Số Lượng</th>
						<th>Loại</th>
						<th>Giá</th>
						<th>Edit</th>
					</tr>
					<%
						ShowCart SC = new ShowCart();
						List<Cart> CartUser = SC.GetAllCart(User.getEmail_acc());
						if(CartUser.isEmpty()){
							%>
								<tr>
									<td colspan="5">Chưa có sãn phẩm nào trong giỏ hàng</td>
								</tr>
							<%
						}else{
							for(Cart C : CartUser){
								%>
									<tr>
										<td><%= C.getName_pd() %></td>
										<td><%= C.getQuantity() %></td>
										<td><%= C.getType_pd() %></td>
										<td>
											<%
												GetMoneyProduct GMP = new GetMoneyProduct();
												out.print(df.format(GMP.GetMoney(C.getId(), C.getType_pd())*C.getQuantity()));
											%>
											 VND
										</td>
										<td><a href="DeleteCart?Id=<%= C.getId() %>&Email=<%= User.getEmail_acc()%>"><i class="fa-solid fa-trash"></i></a></td>
									</tr>
								<%
							}
							double Money = 0;
							for(Cart C : CartUser){
								GetMoneyProduct GMP = new GetMoneyProduct();
								Money = Money + C.getQuantity()*GMP.GetMoney(C.getId(), C.getType_pd());
								request.getSession().setAttribute("SumMoney", Money);
							}
							%>
								<tr class="AC-T-SumMoney">
									<td colspan="3"><h4>Tổng Tiền</h4></td>
									<td colspan="2"><%= df.format(request.getSession().getAttribute("SumMoney")) %> VND</td>
								</tr>	
							<%
						}
					%>
					
				</table>
			</div>
		</div>
		<div class="Account-History">
			<div class="AH-Title"><h4>Đã Mua</h4></div>
			<div class="AH-Table">
				<table>
					<tr>
						<th>Tên</th>
						<th>Số Lượng</th>
						<th>Loại</th>
						<th>Giá</th>
						<th>Ngày Mua</th>
					</tr>
					<%
						ShowHistoryBuy SHB = new ShowHistoryBuy();
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						List<History> HistoryBuy = SHB.GetHistory(User.getEmail_acc());
						if(HistoryBuy.isEmpty()){
							%>
								<tr>
									<td colspan="6">Chưa có sản phẩm nào được mua</td>
								</tr>
							<%
						}else{
							for(History H : HistoryBuy){
								%>
									<tr>
										<td><%= H.getName_pd() %></td>
										<td><%= H.getQuantity() %></td>
										<td><%= H.getType_pd() %></td>
										<td>
											<%
												GetMoneyProduct GMP = new GetMoneyProduct();
												out.print(df.format(GMP.GetMoney(H.getId(), H.getType_pd())*H.getQuantity()));
											%>
											 VND
										</td>
										<td><%= H.getDate_buy().format(dtf) %></td>
									</tr>
								<%
							}
						}
					%>
				</table>
			</div>
		</div>
	</div>
	<div class="<% if(request.getSession().getAttribute("ErrorAccount") == null || request.getSession().getAttribute("ErrorAccount").toString().equals("NoError")){ out.print("NoError"); }else{ out.print("Error"); }%>">
		<div class="A-Cancle"><a href="CancelAccountError"><i class="fa-solid fa-xmark"></i></a></div>
		<div class="A-Error-Content">
			<p><%  if(request.getSession().getAttribute("ErrorAccountContent") == null){ out.print("NoError"); }else{ out.print(request.getSession().getAttribute("ErrorAccountContent").toString()); } %></p>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/489bd3f8d2.js" crossorigin="anonymous"></script>
</body>
</html>