package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.Date;

public class InsertAccount {
	
	public static Account InsertAcc(String Email, String Name, String Password, Connection Conn) throws Exception{
		String Query1 = "INSERT INTO accounts (email_acc,name_acc,password_acc,role_acc,money_acc,date_create_acc) VALUE (?,?,?,?,?,?) ";
		Date currentDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		try (PreparedStatement State = Conn.prepareStatement(Query1)){
			State.setString(1, Email);
			State.setString(2, Name);
			State.setString(3, Password);
			State.setString(4, "User");
			State.setDouble(5, 0);
			State.setDate(6, sqlDate);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Account Acc = AccountGetInfor.GetInfor(Email, Password, Conn);
		return Acc;
	}
}
