package com.inventory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowAllHP {
	public List<Product> GetAllHP(Connection Conn) throws Exception{
		List<Product> HP = new ArrayList<Product>();
		String Query = "SELECT * FROM products_headphone";
		try {
			Statement State = Conn.createStatement();
			ResultSet Result = State.executeQuery(Query);
			while(Result.next()) {
				Product P = new Product();
				P.setId(Result.getString("id"));
				P.setName_pd(Result.getString("name_pd"));
				P.setImage_pd(Result.getString("image_pd"));
				P.setType_pd(Result.getString("type_pd"));
				P.setPrice_pd(Result.getDouble("price_pd"));
				P.setProducer_pd(Result.getString("producer_pd"));
				HP.add(P);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HP;
	}
}
