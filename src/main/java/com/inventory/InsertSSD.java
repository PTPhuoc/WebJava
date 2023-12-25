package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertSSD {
	public void Insert( String Id, String Name, String Image, String Type, Double Price, String Producer, String Memory, String Connect, String Speed, Connection Conn) throws Exception{
		String Query = "INSERT INTO products_ssd (id,image_pd,name_pd,type_pd,price_pd,producer_pd,memory_pd,connect_pd,speed_pd) VALUES (?,?,?,?,?,?,?,?,?);";
		try (PreparedStatement State = Conn.prepareStatement(Query)){
			State.setString(1, Id);
			State.setString(2, Image);
			State.setString(3, Name);
			State.setString(4, Type);
			State.setDouble(5, Price);
			State.setString(6, Producer);
			State.setString(7, Memory);
			State.setString(8, Connect);
			State.setString(9, Speed);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
