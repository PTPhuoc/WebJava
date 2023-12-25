package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertKeyBoard {
	public void Insert( String Id, String Name, String Image, String Type, Double Price, String Producer, String Connect, String Switch, String Led, Connection Conn) throws Exception{
		String Query = "INSERT INTO products_keyboard (id,image_pd,name_pd,type_pd,price_pd,producer_pd,connect_pd,switch_pd,led_pd) VALUES (?,?,?,?,?,?,?,?,?);";
		try (PreparedStatement State = Conn.prepareStatement(Query)){
			State.setString(1, Id);
			State.setString(2, Image);
			State.setString(3, Name);
			State.setString(4, Type);
			State.setDouble(5, Price);
			State.setString(6, Producer);
			State.setString(7, Connect);
			State.setString(8, Switch);
			State.setString(9, Led);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
