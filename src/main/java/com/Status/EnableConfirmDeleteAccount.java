package com.Status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EnableConfirmDeleteAccount")
public class EnableConfirmDeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("email");
		request.getSession().setAttribute("StatusConfirmAccount", "EnableConfirm");
		request.getSession().setAttribute("DeleteEmail", Email);
		request.getSession().setAttribute("StatusPageAdminAccount", "Disable");
		response.sendRedirect("AdminAccount.jsp");
	}

}
