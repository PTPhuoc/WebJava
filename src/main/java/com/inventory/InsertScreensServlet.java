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

@WebServlet("/InsertScreens")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024, // 1 MB
	    maxFileSize = 1024 * 1024 * 10, // 10 MB
	    maxRequestSize = 1024 * 1024 * 50 // 50 MB
)
public class InsertScreensServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("Id");
		String Name = request.getParameter("Name");
		String Type = request.getSession().getAttribute("SelectInsertProducer").toString();
		String Price = request.getParameter("Price");
		String Producer = request.getParameter("Producer");
		String Size = request.getParameter("Size");
		String SType = request.getParameter("Type");
		String AspectRatio = request.getParameter("AspectRatio");
		String Resolution = request.getParameter("Resolution");
		String Frequence = request.getParameter("Frequence");
		Part filePart = request.getPart("Image");
		InputStream fileContent = filePart.getInputStream();
		String uploadPath = "D:/LAP/JAVAWEB/ShopLinhKien/src/main/webapp/Image";
		Files.copy(fileContent, Paths.get(uploadPath, Id + ".png"), StandardCopyOption.REPLACE_EXISTING);
		try {
			InsertScreens I = new InsertScreens();
			I.Insert(Id, Name, "Image/" + Id, Type, Double.valueOf(Price) , Producer, Size, AspectRatio, Resolution, SType, Frequence, MySQLConnect.GetConnect());
			request.getSession().setAttribute("SelectInsertProducer", null);
			request.getSession().setAttribute("StatusPageProduct", "Enable");
			response.sendRedirect("AdminProductList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("AdminProductList.jsp");
		}
	}
}
