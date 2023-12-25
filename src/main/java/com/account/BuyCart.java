package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.MySQL.MySQLConnect;

public class BuyCart {
	public void Buy(String Email) throws Exception{
		String Query1 = "INSERT INTO accounts_history (serie, id, email_acc, quantity, name_pd, type_pd, date_buy) " +
                "SELECT CONCAT(id, NOW()) AS serie, id, email_acc, quantity, name_pd, type_pd, NOW() AS date_buy " +
                "FROM accounts_cart WHERE email_acc=?";
		Connection Conn = MySQLConnect.GetConnect();
		try (PreparedStatement State1 = Conn.prepareStatement(Query1)) {
			State1.setString(1, Email);
			State1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String Query2 = "DELETE FROM accounts_cart\r\n"
				+ "WHERE id IN (SELECT id FROM accounts_history WHERE email_acc=?);";
		try (PreparedStatement State2 = Conn.prepareStatement(Query2)) {
			State2.setString(1, Email);
			State2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
