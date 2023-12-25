package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditAccount {
	public void SetAccount(String Email, String Name, String Role, Double Money, Connection Conn) throws Exception{
		String Query = "UPDATE accounts SET name_acc=?, role_acc=?, money_acc=? WHERE email_acc=?";
		try(PreparedStatement State = Conn.prepareStatement(Query)) {
			State.setString(1, Name);
			State.setString(2, Role);
			State.setDouble(3, Money);
			State.setString(4, Email);
			State.executeUpdate();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
