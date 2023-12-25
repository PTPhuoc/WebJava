package com.account;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.MySQL.MySQLConnect;

@WebServlet("/DeleteAccount")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email = (String) request.getSession().getAttribute("DeleteEmail");
		try {
			DeleteAccount DA = new DeleteAccount();
			DA.DropAccount(Email, MySQLConnect.GetConnect());
			response.sendRedirect("AdminAccount.jsp");
			request.getSession().setAttribute("StatusConfirmAccount", "DisableConfirm");
			response.sendRedirect("AdminAccount.jsp");
 		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
