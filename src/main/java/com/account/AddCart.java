package com.account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = request.getParameter("Email");
		String Id = request.getParameter("Id");
		String Type = request.getParameter("Type");
		String Name = request.getParameter("Name");
		
		try {
			CheckSimilarCart CSC = new CheckSimilarCart();
			boolean Check = CSC.Check(Email, Id);
			if(Check == true) {
				InsertCart IC = new InsertCart();
				IC.Inser(Id, Name, Type, Email);
				response.sendRedirect("Account.jsp");
			}else {
				GetQuantityCart GQC = new GetQuantityCart();
				int Quantity = GQC.GetQuantity(Email, Id);
				UpdateQuantityCart UQC = new UpdateQuantityCart();
				UQC.Update(Email, Id, Quantity + 1);
				response.sendRedirect("Account.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Account.jsp");
		}
	}

}
