package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertScreens {
	public void Insert( String Id, String Name, String Image, String Type, Double Price, String Producer, String Size, String AspectRatio, String Resolution, String SType, String Frequence, Connection Conn) throws Exception{
		String Query = "INSERT INTO products_srceens (id,image_pd,name_pd,type_pd,price_pd,producer_pd,size_pd,pspect_ratio_pd,resolution_pd,screen_type_pd,scan_frequence_pd) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		try (PreparedStatement State = Conn.prepareStatement(Query)){
			State.setString(1, Id);
			State.setString(2, Image);
			State.setString(3, Name);
			State.setString(4, Type);
			State.setDouble(5, Price);
			State.setString(6, Producer);
			State.setString(7, Size);
			State.setString(8, AspectRatio);
			State.setString(9, Resolution);
			State.setString(10, SType);
			State.setString(11, Frequence);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
