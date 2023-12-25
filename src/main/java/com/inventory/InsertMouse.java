package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertMouse {
	public void Insert( String Id, String Name, String Image, String Type, Double Price, String Producer, String Model, String Connect, String Color, Connection Conn) throws Exception{
		String Query = "INSERT INTO products_mouse (id,image_pd,name_pd,type_pd,price_pd,producer_pd,model_pd,connect_pd,color_pd) VALUES (?,?,?,?,?,?,?,?,?);";
		try (PreparedStatement State = Conn.prepareStatement(Query)){
			State.setString(1, Id);
			State.setString(2, Image);
			State.setString(3, Name);
			State.setString(4, Type);
			State.setDouble(5, Price);
			State.setString(6, Producer);
			State.setString(7, Model);
			State.setString(8, Connect);
			State.setString(9, Color);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
