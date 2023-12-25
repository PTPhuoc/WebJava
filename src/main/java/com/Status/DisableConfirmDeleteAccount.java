package com.Status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DisableConfirmDeleteAccount")
public class DisableConfirmDeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("StatusConfirmAccount", "DisableConfirm");
		request.getSession().setAttribute("StatusPageAdminAccount", "Enable");
		request.getSession().setAttribute("DeleteEmail", null);
		response.sendRedirect("AdminAccount.jsp");
	}

}
