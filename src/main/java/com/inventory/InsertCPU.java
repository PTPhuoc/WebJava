package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertCPU {
	public void Insert( String Id, String Name, String Image, String Type, Double Price, String Producer, String CoreAndThread, String Turbo, String Electric, Connection Conn) throws Exception{
		String Query = "INSERT INTO products_cpu (id,image_pd,name_pd,type_pd,price_pd,producer_pd,core_thread_pd,turbo_pd,electric_pd) VALUES (?,?,?,?,?,?,?,?,?);";
		try (PreparedStatement State = Conn.prepareStatement(Query)){
			State.setString(1, Id);
			State.setString(2, Image);
			State.setString(3, Name);
			State.setString(4, Type);
			State.setDouble(5, Price);
			State.setString(6, Producer);
			State.setString(7, CoreAndThread);
			State.setString(8, Turbo);
			State.setString(9, Electric);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
