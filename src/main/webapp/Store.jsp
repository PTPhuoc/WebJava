<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.inventory.*"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/Compoment/Head.jsp"%>
<link rel="stylesheet" href="Style/Store.css">
</head>
<body>
	<div class="Store-SideBar">
		<%@ include file="/Compoment/SideBar.jsp"%>
	</div>
	<div class="Store">
		<div class="Store-List">
			<div class="SL-Search"><form action="FindProduct" method="get"><input type="text" name="TextFind" placeholder="Tìm Kiếm..."><button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button></form></div>
			<div class="SL-Type">
				<div><a href="Store.jsp">ALL</a></div>
				<div><a href="CPU.jsp">CPU</a></div>
				<div><a href="HDD.jsp">HDD</a></div>
				<div><a href="HeadPhone.jsp">HEAD PHONE</a></div>
				<div><a href="KeyBoard.jsp">KEYBOARD</a></div>
				<div><a href="Mouse.jsp">MOUSE</a></div>
				<div><a href="Ram.jsp">RAM</a></div>
				<div><a href="Screens.jsp">SCREENS</a></div>
				<div><a href="SSD.jsp">SSD</a></div>
				<div><a href="VGA.jsp">VGA</a></div>
			</div>
			
		</div>
		<div class="Store-Product-List">
			<%
				if(request.getSession().getAttribute("TextFind") == null){
					DecimalFormat df = new DecimalFormat("###,###,###.0");
					AllProduct AP = new AllProduct();
					List<Product> AllP = AP.GetAllProduct(); 
					for(Product P : AllP){
						%>
							<div class="SPL-Detail">
								<div>
									<a href="MoreInfore?Id=<%= P.getId()%>&Type=<%= P.getType_pd()%>">
										<div><img alt="<%= P.getImage_pd()%>.png" src="<%= P.getImage_pd()%>.png"></div>
										<div class="SPLD-Title">
											<div>
												<i class="fa-solid fa-tags"></i>
											</div>
											<div>
												<p>
													<% 
														if( P.getName_pd().length() <= 20 ){
															out.print(P.getName_pd());
														}else{
															out.print(P.getName_pd().substring(0, 20) + "...");
														}
													%>
												</p>
											</div>
										</div>
										<div class="SPLD-Title">
											<div>
												<i class="fa-solid fa-credit-card"></i>
											</div>
											<div>
												<p><%= df.format(P.getPrice_pd()) %> VND</p>
											</div>
										</div>
										<div class="SPLD-Title">
											<div>
												<i class="fa-solid fa-cube"></i>
											</div>
											<div>
												<p><%= P.getType_pd() %></p>
											</div>
										</div>
										<div class="SPLD-Title">
											<div>
												<i class="fa-solid fa-warehouse"></i>
											</div>
											<div>
												<p><%= P.getProducer_pd() %></p>
											</div>
										</div>
									</a>
								</div>
								<div>
									<%
									
									if(request.getSession().getAttribute("User") != null){
										Object UserObj = request.getSession().getAttribute("User");
										Account User = (Account) UserObj;
										
										%>
											<button onclick="window.location='<%=request.getContextPath()%>/AddCart?Id=<%= P.getId()%>&Name=<%= P.getName_pd()%>&Type=<%= P.getType_pd()%>&Email=<%= User.getEmail_acc()%>'">Thêm vào giỏ hàng</button>
										<%
									}
									%>
								</div>
							</div>
						<%
					}
				}else{
					DecimalFormat df = new DecimalFormat("###,###,###.0");
					FindProduct FP = new FindProduct();
					List<Product> ListPF = FP.GetProductFind(request.getSession().getAttribute("TextFind").toString());
					for(Product P : ListPF){
						%>
							<div class="SPL-Detail">
								<div>
									<a href="MoreInfore?Id=<%= P.getId()%>&Type=<%= P.getType_pd()%>">
										<div><img alt="<%= P.getImage_pd()%>.png" src="<%= P.getImage_pd()%>.png"></div>
										<div class="SPLD-Title">
											<div>
												<i class="fa-solid fa-tags"></i>
											</div>
											<div>
												<p>
													<% 
														if( P.getName_pd().length() <= 20 ){
															out.print(P.getName_pd());
														}else{
															out.print(P.getName_pd().substring(0, 20) + "...");
														}
													%>
												</p>
											</div>
										</div>
										<div class="SPLD-Title">
											<div>
												<i class="fa-solid fa-credit-card"></i>
											</div>
											<div>
												<p><%= df.format(P.getPrice_pd()) %> VND</p>
											</div>
										</div>
										<div class="SPLD-Title">
											<div>
												<i class="fa-solid fa-cube"></i>
											</div>
											<div>
												<p><%= P.getType_pd() %></p>
											</div>
										</div>
										<div class="SPLD-Title">
											<div>
												<i class="fa-solid fa-warehouse"></i>
											</div>
											<div>
												<p><%= P.getProducer_pd() %></p>
											</div>
										</div>
									</a>
								</div>
								<div>
									<%
									
									if(request.getSession().getAttribute("User") != null){
										Object UserObj = request.getSession().getAttribute("User");
										Account User = (Account) UserObj;
										
										%>
											<button onclick="window.location='<%=request.getContextPath()%>/AddCart?Id=<%= P.getId()%>&Name=<%= P.getName_pd()%>&Type=<%= P.getType_pd()%>&Email=<%= User.getEmail_acc()%>'">Thêm vào giỏ hàng</button>
										<%
									}
									%>
								</div>
							</div>
						<%
					}
				}
			%>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/489bd3f8d2.js" crossorigin="anonymous"></script>
</body>
</html>