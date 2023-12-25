package com.account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.MySQL.MySQLConnect;

@WebServlet("/BuyCart")
public class BuyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("Email");
		double Price = (double) request.getSession().getAttribute("SumMoney");
		GetInforAccountWithEmail GIAE = new GetInforAccountWithEmail();
		try {
			Account User = GIAE.GetInfor(Email, MySQLConnect.GetConnect());
			if(User.getMoney_acc() < Price) {
				request.getSession().setAttribute("ErrorAccount", "Error");
				request.getSession().setAttribute("ErrorAccountContent", "Số Dư Không Đủ");
				response.sendRedirect("Account.jsp");
			}else {
				double NewMoney = User.getMoney_acc() - Price;
				UpdateMoneyAccount UMA = new UpdateMoneyAccount();
				BuyCart BC = new BuyCart();
				UMA.Update(Email, NewMoney);
				BC.Buy(Email);
				request.getSession().setAttribute("ErrorAccount", "NoError");
				response.sendRedirect("Account.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
