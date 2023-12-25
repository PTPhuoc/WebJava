package com.Status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DisableEditAccount")
public class DisableEditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("StatusEditAccount", "DisableEdit");
		request.getSession().setAttribute("EditAccount", null);
		request.getSession().setAttribute("StatusPageAdminAccount", "Enable");
		request.getSession().setAttribute("ErrorEditMoney", "NoError");
		response.sendRedirect("AdminAccount.jsp");
	}
}
