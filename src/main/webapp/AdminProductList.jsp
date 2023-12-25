<%@page import="com.MySQL.MySQLConnect"%>
<%@page import="com.inventory.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN MODE</title>
<%@include file="/Compoment/Head.jsp"%>
<link rel="stylesheet" href="Style/AdminIndex.css">
<link rel="stylesheet" href="Style/AdminProduct.css">
</head>
<body>
	<div class="AdminIndex" id="<%= request.getSession().getAttribute("StatusPageProduct")%>">
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
			<div class="AP-Right">
				<div class="AP-Title">
					<div>
						<h3>PRODUCT</h3>
					</div>
					<div>
						<a href="EnableSelectInserProduct"><i class="fa-solid fa-plus"></i></a>
					</div>
				</div>
				<div>
					<div class="AP-Line"></div>
				</div>
				<div class="AP-Table">
					<table>
						<tr>
							<th>IMAGE</th>
							<th>NAME</th>
							<th>TYPE</th>
							<th>PRICE</th>
							<th>PRODUCER</th>
							<th>EDIT</th>
						</tr>
						<%
							DecimalFormat df = new DecimalFormat("###,###,###.0");
							ShowAllCPU ShowCPU = new ShowAllCPU();
							List<Product> CPU = ShowCPU.GetAllCPU(MySQLConnect.GetConnect());
							if(!CPU.isEmpty()){
								for(Product P : CPU){
									%>
										<tr>
											<td><img src="<%= P.getImage_pd()%>.png" alt="<%= P.getImage_pd()%>"></td>
											<td><%= P.getName_pd()%></td>
											<td><%= P.getType_pd()%></td>
											<td><%= df.format(P.getPrice_pd()) %> VND</td>
											<td><%= P.getProducer_pd()%></td>
											<td class="AP-Edit">
												<a href="EnableConfirmDeleteProduct?id=<%= P.getId()%>&type=<%= P.getType_pd()%>"><i
													class="fa-solid fa-trash"></i></a>
											</td>
										</tr>
									<%
								}
							}
							
							ShowAllHdd ShowHdd = new ShowAllHdd();
							List<Product> Hdd = ShowHdd.GetAllHDD(MySQLConnect.GetConnect());
							if(!Hdd.isEmpty()){
								for(Product P : Hdd){
									%>
										<tr>
											<td><img src="<%= P.getImage_pd()%>.png" alt="<%= P.getImage_pd()%>"></td>
											<td><%= P.getName_pd()%></td>
											<td><%= P.getType_pd()%></td>
											<td><%= df.format(P.getPrice_pd())%> VND</td>
											<td><%= P.getProducer_pd()%></td>
											<td class="AP-Edit">
												<a href="EnableConfirmDeleteProduct?id=<%= P.getId()%>&type=<%= P.getType_pd()%>"><i
													class="fa-solid fa-trash"></i></a>
											</td>
										</tr>
									<%
								}
							}
							
							ShowAllHP ShowHP = new ShowAllHP();
							List<Product> HP = ShowHP.GetAllHP(MySQLConnect.GetConnect());
							if(!Hdd.isEmpty()){
								for(Product P : HP){
									%>
										<tr>
											<td><img src="<%= P.getImage_pd()%>.png" alt="<%= P.getImage_pd()%>"></td>
											<td><%= P.getName_pd()%></td>
											<td><%= P.getType_pd()%></td>
											<td><%= df.format(P.getPrice_pd())%> VND</td>
											<td><%= P.getProducer_pd()%></td>
											<td class="AP-Edit">
												<a href="EnableConfirmDeleteProduct?id=<%= P.getId()%>&type=<%= P.getType_pd()%>"><i
													class="fa-solid fa-trash"></i></a>
											</td>
										</tr>
									<%
								}
							}
							ShowAllKB ShowKB = new ShowAllKB();
							List<Product> KB = ShowKB.GetAllKB(MySQLConnect.GetConnect());
							if(!Hdd.isEmpty()){
								for(Product P : KB){
									%>
										<tr>
											<td><img src="<%= P.getImage_pd()%>.png" alt="<%= P.getImage_pd()%>"></td>
											<td><%= P.getName_pd()%></td>
											<td><%= P.getType_pd()%></td>
											<td><%= df.format(P.getPrice_pd())%> VND</td>
											<td><%= P.getProducer_pd()%></td>
											<td class="AP-Edit">
												<a href="EnableConfirmDeleteProduct?id=<%= P.getId()%>&type=<%= P.getType_pd()%>"><i
													class="fa-solid fa-trash"></i></a>
											</td>
										</tr>
									<%
								}
							}
							ShowAllM ShowM = new ShowAllM();
							List<Product> M = ShowM.GetAllM(MySQLConnect.GetConnect());
							if(!Hdd.isEmpty()){
								for(Product P : M){
									%>
										<tr>
											<td><img src="<%= P.getImage_pd()%>.png" alt="<%= P.getImage_pd()%>"></td>
											<td><%= P.getName_pd()%></td>
											<td><%= P.getType_pd()%></td>
											<td><%= df.format(P.getPrice_pd())%> VND</td>
											<td><%= P.getProducer_pd()%></td>
											<td class="AP-Edit">
												<a href="EnableConfirmDeleteProduct?id=<%= P.getId()%>&type=<%= P.getType_pd()%>"><i
													class="fa-solid fa-trash"></i></a>
											</td>
										</tr>
									<%
								}
							}
						ShowAllR ShowR = new ShowAllR();
							List<Product> R = ShowR.GetAllR(MySQLConnect.GetConnect());
							if(!Hdd.isEmpty()){
								for(Product P : R){
									%>
										<tr>
											<td><img src="<%= P.getImage_pd()%>.png" alt="<%= P.getImage_pd()%>"></td>
											<td><%= P.getName_pd()%></td>
											<td><%= P.getType_pd()%></td>
											<td><%= df.format(P.getPrice_pd())%> VND</td>
											<td><%= P.getProducer_pd()%></td>
											<td class="AP-Edit">
												<a href="EnableConfirmDeleteProduct?id=<%= P.getId()%>&type=<%= P.getType_pd()%>"><i
													class="fa-solid fa-trash"></i></a>
											</td>
										</tr>
									<%
								}
							}
						ShowAllSC ShowSC = new ShowAllSC();
							List<Product> SC = ShowSC.GetAllSC(MySQLConnect.GetConnect());
							if(!Hdd.isEmpty()){
								for(Product P : SC){
									%>
										<tr>
											<td><img src="<%= P.getImage_pd()%>.png" alt="<%= P.getImage_pd()%>"></td>
											<td><%= P.getName_pd()%></td>
											<td><%= P.getType_pd()%></td>
											<td><%= df.format(P.getPrice_pd())%> VND</td>
											<td><%= P.getProducer_pd()%></td>
											<td class="AP-Edit">
												<a href="EnableConfirmDeleteProduct?id=<%= P.getId()%>&type=<%= P.getType_pd()%>"><i
													class="fa-solid fa-trash"></i></a>
											</td>
										</tr>
									<%
								}
							}
						ShowAllSSD ShowSSD = new ShowAllSSD();
							List<Product> SSD = ShowSSD.GetAllSSD(MySQLConnect.GetConnect());
							if(!Hdd.isEmpty()){
								for(Product P : SSD){
									%>
										<tr>
											<td><img src="<%= P.getImage_pd()%>.png" alt="<%= P.getImage_pd()%>"></td>
											<td><%= P.getName_pd()%></td>
											<td><%= P.getType_pd()%></td>
											<td><%= df.format(P.getPrice_pd())%> VND</td>
											<td><%= P.getProducer_pd()%></td>
											<td class="AP-Edit">
												<a href="EnableConfirmDeleteProduct?id=<%= P.getId()%>&type=<%= P.getType_pd()%>"><i
													class="fa-solid fa-trash"></i></a>
											</td>
										</tr>
									<%
								}
							}
							ShowAllVGA ShowVGA = new ShowAllVGA();
							List<Product> VGA = ShowVGA.GetAllVGA(MySQLConnect.GetConnect());
							if(!Hdd.isEmpty()){
								for(Product P : VGA){
									%>
										<tr>
											<td><img src="<%= P.getImage_pd()%>.png" alt="<%= P.getImage_pd()%>"></td>
											<td><%= P.getName_pd()%></td>
											<td><%= P.getType_pd()%></td>
											<td><%= df.format(P.getPrice_pd())%> VND</td>
											<td><%= P.getProducer_pd()%></td>
											<td class="AP-Edit">
												<a href="EnableConfirmDeleteProduct?id=<%= P.getId()%>&type=<%= P.getType_pd()%>"><i
													class="fa-solid fa-trash"></i></a>
											</td>
										</tr>
									<%
								}
							}
						%>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%
		if(request.getSession().getAttribute("StatusSelectInserProduct") != null){
			if(request.getSession().getAttribute("StatusSelectInserProduct").toString().equals("Enable")){
			%>
				<div class="AP-SelectInsert">
					<div class="AP-SI-BR">
						<div class="AP-SI-Title">
							<div>
								<h2>ADD PRODUCER</h2>
							</div>
						</div>
						<div class="AP-SI-Option">
							<div>
								<a href="EnableInsertProduct?Type=CPU">CPU</a>
							</div>
							<div>
								<a  href="EnableInsertProduct?Type=HDD">HDD</a>
							</div>
							<div>
								<a  href="EnableInsertProduct?Type=HeadPhone">HEADPHONE</a>
							</div>
							<div>
								<a  href="EnableInsertProduct?Type=KeyBoard">KEYBOARD</a>
							</div>
							<div>
								<a  href="EnableInsertProduct?Type=Mouse">MOUSE</a>
							</div>
							<div>
								<a  href="EnableInsertProduct?Type=Ram">RAM</a>
							</div>
							<div>
								<a  href="EnableInsertProduct?Type=Screens">SCREENS</a>
							</div>
							<div>
								<a  href="EnableInsertProduct?Type=SSD">SSD</a>
							</div>
							<div>
								<a  href="EnableInsertProduct?Type=VGA">VGA</a>
							</div>
						</div>
						<div class="AP-SI-button">
							<button onclick="window.location='<%=request.getContextPath()%>/DisableSelectInsertProduct'">HỦY</button>
						</div>
					</div>
				</div>
			<%
			}
		}
		
		if(request.getSession().getAttribute("SelectInsertProducer") != null){
			if(request.getSession().getAttribute("SelectInsertProducer").toString().equals("CPU")){
				%>
					<div class="AP-Insert">
						<div class="AP-I-BR">
							<div class="AP-I-Title">
								<h3>ADD CPU</h3>
							</div>
							<div class="AP-I-Action">
								<form class="AP-I-Form" action="InsertCPU" method="post" enctype="multipart/form-data">
									<div>
										<div><h4>ID</h4></div>
										<div><input type="text" name="Id"></div>
									</div>
									<div>
										<div><h4>IMAGE</h4></div>
										<div><input  type="file" name="Image"></div>
									</div>
									<div>
										<div><h4>NAME</h4></div>
										<div><input type="text" name="Name"></div>
									</div>
									<div>
										<div><h4>PRICE</h4></div>
										<div><input type="text" name="Price"></div>
									</div>
									<div>
										<div><h4>PRODUCER</h4></div>
										<div><input type="text" name="Producer"></div>
									</div>
									<div>
										<div><h4>CORE AND THREAD</h4></div>
										<div><input  type="text" name="CoreAndThread"></div>
									</div>
									<div>
										<div><h4>TUBO</h4></div>
										<div><input  type="text" name="Turbo"></div>
									</div>
									<div>
										<div><h4>ELECTRIC</h4></div>
										<div><input  type="text" name="Electric"></div>
									</div>
									<div class="AP-I-Submit">
										<button type="submit">XÁC NHẬN</button>
									</div>
								</form>
							</div>
							<div class="AP-I-Bottom">
								<button onclick="window.location='<%=request.getContextPath()%>/DisableInsertProduct'">HỦY</button>
							</div>
						</div>
					</div>
				<%
			}else if(request.getSession().getAttribute("SelectInsertProducer").toString().equals("HDD")){
				%>
				<div class="AP-Insert">
					<div class="AP-I-BR">
						<div class="AP-I-Title">
							<h3>ADD HDD</h3>
						</div>
						<div class="AP-I-Action">
							<form class="AP-I-Form" action="InsertHDD" method="post" enctype="multipart/form-data">
								<div>
									<div><h4>ID</h4></div>
									<div><input type="text" name="Id"></div>
								</div>
								<div>
									<div><h4>IMAGE</h4></div>
									<div><input  type="file" name="Image"></div>
								</div>
								<div>
									<div><h4>NAME</h4></div>
									<div><input type="text" name="Name"></div>
								</div>
								<div>
									<div><h4>PRICE</h4></div>
									<div><input type="text" name="Price"></div>
								</div>
								<div>
									<div><h4>PRODUCER</h4></div>
									<div><input type="text" name="Producer"></div>
								</div>
								<div>
									<div><h4>SERIES</h4></div>
									<div><input  type="text" name="Serie"></div>
								</div>
								<div>
									<div><h4>MEMORY</h4></div>
									<div><input  type="text" name="Memory"></div>
								</div>
								<div>
									<div><h4>CONNECT</h4></div>
									<div><input  type="text" name="Connect"></div>
								</div>
								<div>
									<div><h4>SPEED</h4></div>
									<div><input  type="text" name="Speed"></div>
								</div>
								<div class="AP-I-Submit">
									<button type="submit">XÁC NHẬN</button>
								</div>
							</form>
						</div>
						<div class="AP-I-Bottom">
							<button onclick="window.location='<%=request.getContextPath()%>/DisableInsertProduct'">HỦY</button>
						</div>
					</div>
				</div>
			<%
				}else if(request.getSession().getAttribute("SelectInsertProducer").toString().equals("HeadPhone")){
					%>
					<div class="AP-Insert">
						<div class="AP-I-BR">
							<div class="AP-I-Title">
								<h3>ADD HEADPHONE</h3>
							</div>
							<div class="AP-I-Action">
								<form class="AP-I-Form" action="InsertHeadPhone" method="post" enctype="multipart/form-data">
									<div>
										<div><h4>ID</h4></div>
										<div><input type="text" name="Id"></div>
									</div>
									<div>
										<div><h4>IMAGE</h4></div>
										<div><input  type="file" name="Image"></div>
									</div>
									<div>
										<div><h4>NAME</h4></div>
										<div><input type="text" name="Name"></div>
									</div>
									<div>
										<div><h4>PRICE</h4></div>
										<div><input type="text" name="Price"></div>
									</div>
									<div>
										<div><h4>PRODUCER</h4></div>
										<div><input type="text" name="Producer"></div>
									</div>
									<div>
										<div><h4>MODEL</h4></div>
										<div><input  type="text" name="Model"></div>
									</div>
									<div>
										<div><h4>CONNECT</h4></div>
										<div><input  type="text" name="Connect"></div>
									</div>
									<div>
										<div><h4>LED</h4></div>
										<div><input  type="text" name="Led"></div>
									</div>
									<div class="AP-I-Submit">
										<button type="submit">XÁC NHẬN</button>
									</div>
								</form>
							</div>
							<div class="AP-I-Bottom">
								<button onclick="window.location='<%=request.getContextPath()%>/DisableInsertProduct'">HỦY</button>
							</div>
						</div>
					</div>
				<%
			}else if(request.getSession().getAttribute("SelectInsertProducer").toString().equals("KeyBoard")){
				%>
				<div class="AP-Insert">
					<div class="AP-I-BR">
						<div class="AP-I-Title">
							<h3>ADD KEYBOARD</h3>
						</div>
						<div class="AP-I-Action">
							<form class="AP-I-Form" action="InsertKeyBoard" method="post" enctype="multipart/form-data">
								<div>
									<div><h4>ID</h4></div>
									<div><input type="text" name="Id"></div>
								</div>
								<div>
									<div><h4>IMAGE</h4></div>
									<div><input  type="file" name="Image"></div>
								</div>
								<div>
									<div><h4>NAME</h4></div>
									<div><input type="text" name="Name"></div>
								</div>
								<div>
									<div><h4>PRICE</h4></div>
									<div><input type="text" name="Price"></div>
								</div>
								<div>
									<div><h4>PRODUCER</h4></div>
									<div><input type="text" name="Producer"></div>
								</div>
								<div>
									<div><h4>SWITCH</h4></div>
									<div><input  type="text" name="Switch"></div>
								</div>
								<div>
									<div><h4>CONNECT</h4></div>
									<div><input  type="text" name="Connect"></div>
								</div>
								<div>
									<div><h4>LED</h4></div>
									<div><input  type="text" name="Led"></div>
								</div>
								<div class="AP-I-Submit">
									<button type="submit">XÁC NHẬN</button>
								</div>
							</form>
						</div>
						<div class="AP-I-Bottom">
							<button onclick="window.location='<%=request.getContextPath()%>/DisableInsertProduct'">HỦY</button>
						</div>
					</div>
				</div>
			<%
			}else if(request.getSession().getAttribute("SelectInsertProducer").toString().equals("Mouse")){
				%>
				<div class="AP-Insert">
					<div class="AP-I-BR">
						<div class="AP-I-Title">
							<h3>ADD MOUSE</h3>
						</div>
						<div class="AP-I-Action">
							<form class="AP-I-Form" action="InsertMouse" method="post" enctype="multipart/form-data">
								<div>
									<div><h4>ID</h4></div>
									<div><input type="text" name="Id"></div>
								</div>
								<div>
									<div><h4>IMAGE</h4></div>
									<div><input  type="file" name="Image"></div>
								</div>
								<div>
									<div><h4>NAME</h4></div>
									<div><input type="text" name="Name"></div>
								</div>
								<div>
									<div><h4>PRICE</h4></div>
									<div><input type="text" name="Price"></div>
								</div>
								<div>
									<div><h4>PRODUCER</h4></div>
									<div><input type="text" name="Producer"></div>
								</div>
								<div>
									<div><h4>MODEL</h4></div>
									<div><input  type="text" name="Model"></div>
								</div>
								<div>
									<div><h4>CONNECT</h4></div>
									<div><input  type="text" name="Connect"></div>
								</div>
								<div>
									<div><h4>COLOR</h4></div>
									<div><input  type="text" name="Color"></div>
								</div>
								<div class="AP-I-Submit">
									<button type="submit">XÁC NHẬN</button>
								</div>
							</form>
						</div>
						<div class="AP-I-Bottom">
							<button onclick="window.location='<%=request.getContextPath()%>/DisableInsertProduct'">HỦY</button>
						</div>
					</div>
				</div>
			<%
		}else if(request.getSession().getAttribute("SelectInsertProducer").toString().equals("Ram")){
			%>
				<div class="AP-Insert">
					<div class="AP-I-BR">
						<div class="AP-I-Title">
							<h3>ADD RAM</h3>
						</div>
						<div class="AP-I-Action">
							<form class="AP-I-Form" action="InsertRam" method="post" enctype="multipart/form-data">
								<div>
									<div><h4>ID</h4></div>
									<div><input type="text" name="Id"></div>
								</div>
								<div>
									<div><h4>IMAGE</h4></div>
									<div><input  type="file" name="Image"></div>
								</div>
								<div>
									<div><h4>NAME</h4></div>
									<div><input type="text" name="Name"></div>
								</div>
								<div>
									<div><h4>PRICE</h4></div>
									<div><input type="text" name="Price"></div>
								</div>
								<div>
									<div><h4>PRODUCER</h4></div>
									<div><input type="text" name="Producer"></div>
								</div>
								<div>
									<div><h4>SERIES</h4></div>
									<div><input  type="text" name="Serie"></div>
								</div>
								<div>
									<div><h4>TYPE</h4></div>
									<div><input  type="text" name="Type"></div>
								</div>
								<div>
									<div><h4>MEMORY</h4></div>
									<div><input  type="text" name="Memory"></div>
								</div>
								<div>
									<div><h4>BUS</h4></div>
									<div><input  type="text" name="Bus"></div>
								</div>
								<div>
									<div><h4>COLOR</h4></div>
									<div><input  type="text" name="Color"></div>
								</div>
								<div class="AP-I-Submit">
									<button type="submit">XÁC NHẬN</button>
								</div>
							</form>
						</div>
						<div class="AP-I-Bottom">
							<button onclick="window.location='<%=request.getContextPath()%>/DisableInsertProduct'">HỦY</button>
						</div>
					</div>
				</div>
			<%
			}else if(request.getSession().getAttribute("SelectInsertProducer").toString().equals("Screens")){
				%>
				<div class="AP-Insert">
					<div class="AP-I-BR">
						<div class="AP-I-Title">
							<h3>ADD SCREENS</h3>
						</div>
						<div class="AP-I-Action">
							<form class="AP-I-Form" action="InsertScreens" method="post" enctype="multipart/form-data">
								<div>
									<div><h4>ID</h4></div>
									<div><input type="text" name="Id"></div>
								</div>
								<div>
									<div><h4>IMAGE</h4></div>
									<div><input  type="file" name="Image"></div>
								</div>
								<div>
									<div><h4>NAME</h4></div>
									<div><input type="text" name="Name"></div>
								</div>
								<div>
									<div><h4>PRICE</h4></div>
									<div><input type="text" name="Price"></div>
								</div>
								<div>
									<div><h4>PRODUCER</h4></div>
									<div><input type="text" name="Producer"></div>
								</div>
								<div>
									<div><h4>SIZE</h4></div>
									<div><input  type="text" name="Size"></div>
								</div>
								<div>
									<div><h4>ASPECT RATIO</h4></div>
									<div><input  type="text" name="AspectRatio"></div>
								</div>
								<div>
									<div><h4>RESOLUTION</h4></div>
									<div><input  type="text" name="Resolution"></div>
								</div>
								<div>
									<div><h4>TYPE</h4></div>
									<div><input  type="text" name="Type"></div>
								</div>
								<div>
									<div><h4>FREQUENCE</h4></div>
									<div><input  type="text" name="Frequence"></div>
								</div>
								<div class="AP-I-Submit">
									<button type="submit">XÁC NHẬN</button>
								</div>
							</form>
						</div>
						<div class="AP-I-Bottom">
							<button onclick="window.location='<%=request.getContextPath()%>/DisableInsertProduct'">HỦY</button>
						</div>
					</div>
				</div>
			<%
			}else if(request.getSession().getAttribute("SelectInsertProducer").toString().equals("SSD")){
				%>
				<div class="AP-Insert">
					<div class="AP-I-BR">
						<div class="AP-I-Title">
							<h3>ADD SSD</h3>
						</div>
						<div class="AP-I-Action">
							<form class="AP-I-Form" action="InsertSSD" method="post" enctype="multipart/form-data">
								<div>
									<div><h4>ID</h4></div>
									<div><input type="text" name="Id"></div>
								</div>
								<div>
									<div><h4>IMAGE</h4></div>
									<div><input  type="file" name="Image"></div>
								</div>
								<div>
									<div><h4>NAME</h4></div>
									<div><input type="text" name="Name"></div>
								</div>
								<div>
									<div><h4>PRICE</h4></div>
									<div><input type="text" name="Price"></div>
								</div>
								<div>
									<div><h4>PRODUCER</h4></div>
									<div><input type="text" name="Producer"></div>
								</div>
								<div>
									<div><h4>MEMORY</h4></div>
									<div><input  type="text" name="Memory"></div>
								</div>
								<div>
									<div><h4>CONNECT</h4></div>
									<div><input  type="text" name="Connect"></div>
								</div>
								<div>
									<div><h4>SPEED</h4></div>
									<div><input  type="text" name="Speed"></div>
								</div>
								<div class="AP-I-Submit">
									<button type="submit">XÁC NHẬN</button>
								</div>
							</form>
						</div>
						<div class="AP-I-Bottom">
							<button onclick="window.location='<%=request.getContextPath()%>/DisableInsertProduct'">HỦY</button>
						</div>
					</div>
				</div>
			<%
			}else if(request.getSession().getAttribute("SelectInsertProducer").toString().equals("VGA")){
				%>
				<div class="AP-Insert">
					<div class="AP-I-BR">
						<div class="AP-I-Title">
							<h3>ADD VGA</h3>
						</div>
						<div class="AP-I-Action">
							<form class="AP-I-Form" action="InsertVGA" method="post" enctype="multipart/form-data">
								<div>
									<div><h4>ID</h4></div>
									<div><input type="text" name="Id"></div>
								</div>
								<div>
									<div><h4>IMAGE</h4></div>
									<div><input  type="file" name="Image"></div>
								</div>
								<div>
									<div><h4>NAME</h4></div>
									<div><input type="text" name="Name"></div>
								</div>
								<div>
									<div><h4>PRICE</h4></div>
									<div><input type="text" name="Price"></div>
								</div>
								<div>
									<div><h4>PRODUCER</h4></div>
									<div><input type="text" name="Producer"></div>
								</div>
								<div>
									<div><h4>BUS</h4></div>
									<div><input  type="text" name="Bus"></div>
								</div>
								<div>
									<div><h4>MEMORY</h4></div>
									<div><input  type="text" name="Memory"></div>
								</div>
								<div>
									<div><h4>CONNECT</h4></div>
									<div><input  type="text" name="Connect"></div>
								</div>
								<div>
									<div><h4>RESOLUTION</h4></div>
									<div><input  type="text" name="Resolution"></div>
								</div>
								<div class="AP-I-Submit">
									<button type="submit">XÁC NHẬN</button>
								</div>
							</form>
						</div>
						<div class="AP-I-Bottom">
							<button onclick="window.location='<%=request.getContextPath()%>/DisableInsertProduct'">HỦY</button>
						</div>
					</div>
				</div>
			<%
		}
	}
		
		
	%>
	<script src="https://kit.fontawesome.com/489bd3f8d2.js" crossorigin="anonymous"></script>
</body>
</html>