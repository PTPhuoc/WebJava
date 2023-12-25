package com.handle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SignIn-Google")
public class HandleGoogle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HandleGoogle() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		if(code != null) {
			String accessToken = GoogleInfor.getToken(code);
		      GoogleAccount Account = GoogleInfor.getUserInfo(accessToken);
		      request.setAttribute("id", Account.getId());
		      request.setAttribute("name", Account.getName());
		      request.setAttribute("email", Account.getEmail());
		      RequestDispatcher dis = request.getRequestDispatcher("SignUp.jsp");
		      dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("SignUp.jsp");
		    dis.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
