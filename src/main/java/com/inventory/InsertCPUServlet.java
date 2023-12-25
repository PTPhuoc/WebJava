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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.MySQL.MySQLConnect;

@WebServlet("/InsertCPU")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024, // 1 MB
	    maxFileSize = 1024 * 1024 * 10, // 10 MB
	    maxRequestSize = 1024 * 1024 * 50 // 50 MB
	)
public class InsertCPUServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("Id");
		String Name = request.getParameter("Name");
		String Type = request.getSession().getAttribute("SelectInsertProducer").toString();
		String Price = request.getParameter("Price");
		String Producer = request.getParameter("Producer");
		String CoreAndThread = request.getParameter("CoreAndThread");
		String Turbo = request.getParameter("Turbo");
		String Electric = request.getParameter("Electric");
		Part filePart = request.getPart("Image");
		InputStream fileContent = filePart.getInputStream();
		String uploadPath = "D:/LAP/JAVAWEB/ShopLinhKien/src/main/webapp/Image";
		Files.copy(fileContent, Paths.get(uploadPath, Id + ".png"), StandardCopyOption.REPLACE_EXISTING);
		try {
			InsertCPU Icpu = new InsertCPU();
			Icpu.Insert(Id, Name, "Image/" + Id, Type, Double.valueOf(Price) , Producer, CoreAndThread, Turbo, Electric, MySQLConnect.GetConnect());
			request.getSession().setAttribute("SelectInsertProducer", null);
			request.getSession().setAttribute("StatusPageProduct", "Enable");
			response.sendRedirect("AdminProductList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("AdminProductList.jsp");
		}
	}

}
