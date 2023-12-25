package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.MySQL.MySQLConnect;

public class DeleteCart {
	public void Delete(String Id, String Email) throws Exception{
		Connection Conn = MySQLConnect.GetConnect();
		String Query = "DELETE FROM accounts_cart WHERE email_acc=? AND id=?;";
		try (PreparedStatement State = Conn.prepareStatement(Query)){
			State.setString(1, Email);
			State.setString(2, Id);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
