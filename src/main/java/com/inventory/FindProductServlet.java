package com.inventory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FindProduct")
public class FindProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String TextFind = request.getParameter("TextFind");
		if (TextFind.equals("")) {
			request.getSession().setAttribute("TextFind", null);
			response.sendRedirect("Store.jsp");
		} else {
			request.getSession().setAttribute("TextFind", TextFind);
			response.sendRedirect("Store.jsp");
		}
	}

}
