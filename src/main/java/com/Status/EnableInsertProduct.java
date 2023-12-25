package com.Status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EnableInsertProduct")
public class EnableInsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Type = request.getParameter("Type");
		request.getSession().setAttribute("SelectInsertProducer", Type);
		request.getSession().setAttribute("StatusSelectInserProduct", "Disable");
		response.sendRedirect("AdminProductList.jsp");
	}
}
