package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;


public class AccountGetInfor {
	
	public static Account GetInfor(String email, String password, Connection connect) throws Exception{
		Account Acc = null;
		ResultSet Result = null;
		String query = "SELECT * FROM accounts WHERE email_acc=? AND password_acc=?;";
		try(PreparedStatement State = connect.prepareStatement(query)) {
			State.setString(1, email);
			State.setString(2, password);
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
