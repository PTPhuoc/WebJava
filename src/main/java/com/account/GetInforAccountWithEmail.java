package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetInforAccountWithEmail {
	public Account GetInfor(String Email, Connection Conn) throws Exception{
		Account Acc = null;
		ResultSet Result = null;
		String query = "SELECT * FROM accounts WHERE email_acc=?;";
		try(PreparedStatement State = Conn.prepareStatement(query)) {
			State.setString(1, Email);
			Result = State.executeQuery();
			while(Result.next()) {
				Acc = new Account();
				Acc.setEmail_acc(Result.getString("email_acc"));
				Acc.setName_acc(Result.getString("name_acc"));
				Acc.setRole_acc(Result.getString("role_acc"));
				Acc.setMoney_acc(Result.getDouble("money_acc"));
				Acc.setDate_create_acc(Result.getDate("date_create_acc").toLocalDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Acc;
	}
}
