package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.MySQL.MySQLConnect;

public class InsertCart {
	public void Inser(String Id, String Name, String Type, String Email) throws Exception {
		String Query = "INSERT INTO accounts_cart (id,email_acc,quantity,name_pd,type_pd) VALUE (?,?,?,?,?);";
		Connection Conn = MySQLConnect.GetConnect();
		try(PreparedStatement State = Conn.prepareStatement(Query)){
			State.setString(1, Id);
			State.setString(2, Email);
			State.setInt(3, 1);
			State.setString(4, Name);
			State.setString(5, Type);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
