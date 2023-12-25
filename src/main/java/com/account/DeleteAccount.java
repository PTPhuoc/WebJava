package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteAccount {
	public void DropAccount(String Email, Connection Conn) throws Exception{
		String Query = "DELETE accounts WHERE email_acc=?;";
		try(PreparedStatement State = Conn.prepareStatement(Query)) {
			State.setString(1, Email);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
