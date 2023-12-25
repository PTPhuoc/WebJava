package com.Status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.MySQL.MySQLConnect;
import com.account.Account;
import com.account.GetInforAccountWithEmail;

@WebServlet("/EnableEditAccount")
public class EnableEditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Email = request.getParameter("email");
		Account Acc = new Account();
		GetInforAccountWithEmail GetAccount = new GetInforAccountWithEmail();
		try {
			Acc = GetAccount.GetInfor(Email, MySQLConnect.GetConnect());
			request.getSession().setAttribute("EditAccount", Acc);
			request.getSession().setAttribute("StatusEditAccount", "EnableEdit");
			request.getSession().setAttribute("StatusPageAdminAccount", "Disable");
			response.sendRedirect("AdminAccount.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
