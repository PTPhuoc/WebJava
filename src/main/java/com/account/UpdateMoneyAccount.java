package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.MySQL.MySQLConnect;

public class UpdateMoneyAccount {
	public void Update(String Email, double Money) throws Exception{
		Connection Conn = MySQLConnect.GetConnect();
		String Query = "UPDATE accounts SET money_acc=? WHERE email_acc=?;";
		try (PreparedStatement State = Conn.prepareStatement(Query)) {
			State.setDouble(1, Money);
			State.setString(2, Email);
			State.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
