package com.inventory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.MySQL.MySQLConnect;

@WebServlet("/InsertHDD")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024, // 1 MB
	    maxFileSize = 1024 * 1024 * 10, // 10 MB
	    maxRequestSize = 1024 * 1024 * 50 // 50 MB
)
public class InsertHDDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("Id");
		String Name = request.getParameter("Name");
		String Type = request.getSession().getAttribute("SelectInsertProducer").toString();
		String Price = request.getParameter("Price");
		String Producer = request.getParameter("Producer");
		String Serie = request.getParameter("Serie");
		String Memory = request.getParameter("Memory");
		String Connect = request.getParameter("Connect");
		String Speed = request.getParameter("Speed");
		Part filePart = request.getPart("Image");
		InputStream fileContent = filePart.getInputStream();
		String uploadPath = "D:/LAP/JAVAWEB/ShopLinhKien/src/main/webapp/Image";
		Files.copy(fileContent, Paths.get(uploadPath, Id + ".png"), StandardCopyOption.REPLACE_EXISTING);
		try {
			InsertHDD Ihdd = new InsertHDD();
			Ihdd.Insert(Id, Name, "Image/" + Id, Type, Double.valueOf(Price) , Producer, Serie, Memory, Connect, Speed, MySQLConnect.GetConnect());
			request.getSession().setAttribute("SelectInsertProducer", null);
			request.getSession().setAttribute("StatusPageProduct", "Enable");
			response.sendRedirect("AdminProductList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("AdminProductList.jsp");
		}
	}
}
