package com.account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.MySQL.MySQLConnect;

@WebServlet("/EditAccount")
public class EditAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name = request.getParameter("name");
		String Role = request.getParameter("role");
		String Money = request.getParameter("money");
		try {
			if(Double.parseDouble(Money) >= 0) {
				Object EditAccObj = request.getSession().getAttribute("EditAccount");
				Account EditAcc = (Account) EditAccObj;
				EditAccount EA = new EditAccount();
				EA.SetAccount(EditAcc.getEmail_acc(), Name, Role, Double.parseDouble(Money), MySQLConnect.GetConnect());
				request.getSession().setAttribute("StatusEditAccount", "DisableEdit");
				request.getSession().setAttribute("EditAccount", null);
				request.getSession().setAttribute("ErrorEditMoney", "NoError");
				request.getSession().setAttribute("StatusPageAdminAccount", "Enable");
				response.sendRedirect("AdminAccount.jsp");
			}else {
				request.getSession().setAttribute("ErrorEditMoney", "Error");
			}
		} catch (Exception e) {
			request.getSession().setAttribute("ErrorEditMoney", "Error");
			response.sendRedirect("AdminAccount.jsp");
		}
	}

}
