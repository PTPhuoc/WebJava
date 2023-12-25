package com.account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.MySQL.MySQLConnect;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/Login")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			if (CheckEmail.CheckEmailExists(email, MySQLConnect.GetConnect()) == true) {
				request.getSession().setAttribute("Error-Signin-Email", "Error-Email");
				response.sendRedirect("Login.jsp");
			} else {
				try {
					Account Acc = AccountGetInfor.GetInfor(email, password, MySQLConnect.GetConnect());
					if (Acc != null) {
						request.getSession().setAttribute("User", Acc);
						Object User = request.getSession().getAttribute("User");
						Account userAccount = (Account) User;
						System.out.println(userAccount.getEmail_acc());
						request.getSession().setAttribute("Error-Signin-Email", "NoError-Email");
						request.getSession().setAttribute("Error-Signin-Password", "NoError-Password");
						response.sendRedirect("index.jsp");
					} else {
						request.getSession().setAttribute("Error-Signin-Password", "Error-Password");
						response.sendRedirect("Login.jsp");
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					response.sendRedirect("Login.jsp");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
