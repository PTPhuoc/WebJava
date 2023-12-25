package com.account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.MySQL.MySQLConnect;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("SignUp.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Password = request.getParameter("password");
		String RePassword = request.getParameter("repassword");
		Connection Conn = null;
		if (Password.length() < 6) {
			request.getSession().setAttribute("Error-Signin-Password", "Error-Password");
			response.sendRedirect("SignUp.jsp");
		}else if (!Password.equals(RePassword)) {
			request.getSession().setAttribute("Error-Signin-Password", "Error-Password");
			response.sendRedirect("SignUp.jsp");
		} else {
			String Email = request.getParameter("email");
			try {
				Conn = MySQLConnect.GetConnect();
				boolean Check = CheckEmail.CheckEmailExists(Email, Conn);
				if (Check == false) {
					request.getSession().setAttribute("Error-Signin-Email", "Error-Email");
					response.sendRedirect("SignUp.jsp");
				} else {
					String Name = request.getParameter("name");
					try {
						Conn = MySQLConnect.GetConnect();
						Account Acc = InsertAccount.InsertAcc(Email, Name, RePassword, Conn);
						if (Acc != null) {
							request.getSession().setAttribute("User", Acc);
							Object User = request.getSession().getAttribute("User");
							Account userAccount = (Account) User;
							System.out.println(userAccount.getEmail_acc());
							request.getSession().setAttribute("Error-Signin-Password", "NoError-Password");
							request.getSession().setAttribute("Error-Signin-Email", "NoError-Email");
							response.sendRedirect("index.jsp");
						} else {
							response.sendRedirect("SignUp.jsp");
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (Exception e) {
						response.sendRedirect("SignUp.jsp");
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

}
