package com.account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.MySQL.MySQLConnect;

public class ShowAllAccount {

	public List<Account> GetAllAccount() throws Exception {
		List<Account> ListAcc = new ArrayList<Account>();
		String Query = "SELECT * FROM accounts;";
		try {
			Connection Conn = MySQLConnect.GetConnect();
			Statement State = Conn.createStatement();
			ResultSet result = State.executeQuery(Query);
			while (result.next()) {
				Account Acc = new Account();
				Acc.setEmail_acc(result.getString("email_acc"));
				Acc.setName_acc(result.getString("name_acc"));
				Acc.setRole_acc(result.getString("role_acc"));
				Acc.setMoney_acc(result.getDouble("money_acc"));
				Acc.setDate_create_acc(result.getDate("date_create_acc").toLocalDate());
				ListAcc.add(Acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListAcc;
	}
}
