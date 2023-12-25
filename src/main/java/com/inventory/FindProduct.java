package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.MySQL.MySQLConnect;

public class FindProduct {
	public List<Product> GetProductFind(String TextFind) throws Exception {
		String[] Table = { "products_cpu", "products_hdd", "products_headphone", "products_keyboard", "products_mouse",
				"products_ram", "products_screens", "products_ssd", "products_vga" };
		List<Product> ProductFind = new ArrayList<Product>();
		if (TextFind.contains(" ")) {
			String[] EachText = TextFind.split(" ");
			for (int i = 0; i <= Table.length - 1; i++) {
				for (int j = 0; j <= EachText.length - 1; j++) {
					String Query = "SELECT * FROM " + Table[i] + " WHERE name_pd LIKE '%" + EachText[j] + "%'";
					Connection Conn = MySQLConnect.GetConnect();
					try (PreparedStatement State = Conn.prepareStatement(Query)) {
						ResultSet Result = State.executeQuery();
						while (Result.next()) {
							Product P = new Product();
							P.setId(Result.getString("id"));
							P.setName_pd(Result.getString("name_pd"));
							P.setImage_pd(Result.getString("image_pd"));
							P.setType_pd(Result.getString("type_pd"));
							P.setPrice_pd(Result.getDouble("price_pd"));
							P.setProducer_pd(Result.getString("producer_pd"));
							ProductFind.add(P);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
			HashSet<Product> WithoutDuplicates = new HashSet<Product>(ProductFind);
			List<Product> ResultFind = new ArrayList<Product>(WithoutDuplicates);
			return ResultFind;
		} else {
			for (int i = 0; i <= Table.length - 1; i++) {
				Connection Conn = MySQLConnect.GetConnect();
				String Query = "SELECT * FROM " + Table[i] + " WHERE name_pd LIKE '%" + TextFind + "%'";
				try (PreparedStatement State = Conn.prepareStatement(Query)) {
					ResultSet Result = State.executeQuery();
					while (Result.next()) {
						Product P = new Product();
						P.setId(Result.getString("id"));
						P.setName_pd(Result.getString("name_pd"));
						P.setImage_pd(Result.getString("image_pd"));
						P.setType_pd(Result.getString("type_pd"));
						P.setPrice_pd(Result.getDouble("price_pd"));
						P.setProducer_pd(Result.getString("producer_pd"));
						ProductFind.add(P);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			HashSet<Product> WithoutDuplicates = new HashSet<Product>(ProductFind);
			List<Product> ResultFind = new ArrayList<Product>(WithoutDuplicates);
			return ResultFind;
		}
	}
}
