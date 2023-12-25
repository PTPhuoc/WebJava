package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MySQL.MySQLConnect;

public class GetQuantityCart {
	private int Quantity;
	
	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int GetQuantity(String Email, String Id) throws Exception{
		String Query = "SELECT * FROM accounts_cart WHERE email_acc=? AND id=?;";
		Connection Conn = MySQLConnect.GetConnect();
		try(PreparedStatement State = Conn.prepareStatement(Query)){
			State.setString(1, Email);
			State.setString(2, Id);
			ResultSet Result = State.executeQuery();
			while(Result.next()) {
				setQuantity(Result.getInt("quantity"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getQuantity();
	}
}
