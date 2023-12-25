package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertRam {
	public void Insert( String Id, String Name, String Image, String Type, Double Price, String Producer, String Serie, String RType, String Memory, String Bus, String Color, Connection Conn) throws Exception{
		String Query = "INSERT INTO products_ram (id,image_pd,name_pd,type_pd,price_pd,producer_pd,seried_pd,ram_type_pd,memory_pd,bus_pd,color_pd) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		try (PreparedStatement State = Conn.prepareStatement(Query)){
			State.setString(1, Id);
			State.setString(2, Image);
			State.setString(3, Name);
			State.setString(4, Type);
			State.setDouble(5, Price);
			State.setString(6, Producer);
			State.setString(7, Serie);
			State.setString(8, RType);
			State.setString(9, Memory);
			State.setString(10, Bus);
			State.setString(11, Color);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
