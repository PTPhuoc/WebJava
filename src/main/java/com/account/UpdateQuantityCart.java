package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.MySQL.MySQLConnect;

public class UpdateQuantityCart {
	public void Update(String Email, String Id, int Quantity) throws Exception{
		String Query = "UPDATE accounts_cart SET quantity=? WHERE email_acc=? AND id=?;";
		Connection Conn = MySQLConnect.GetConnect();
		try (PreparedStatement State = Conn.prepareStatement(Query)) {
			State.setInt(1, Quantity);
			State.setString(2, Email);
			State.setString(3, Id);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
