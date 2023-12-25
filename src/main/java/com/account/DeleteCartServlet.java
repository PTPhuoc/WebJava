package com.account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteCart")
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("Email");
		String Id = request.getParameter("Id");
		try {
			DeleteCart DC = new DeleteCart();
			DC.Delete(Id, Email);
			response.sendRedirect("Account.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Account.jsp");
		}
	}

}
