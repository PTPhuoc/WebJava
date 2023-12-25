package com.Status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DisableInsertProduct")
public class DisableInsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("SelectInsertProducer", null);
		request.getSession().setAttribute("StatusPageProduct", "Enable");
		response.sendRedirect("AdminProductList.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
