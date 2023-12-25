package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.MySQL.MySQLConnect;

public class CheckSimilarCart {
	private boolean Check;

	public boolean isCheck() {
		return Check;
	}

	public void setCheck(boolean check) {
		Check = check;
	}

	public boolean Check(String Email, String Id) throws Exception {
		List<String> IdCart = new ArrayList<String>();
		String Query = "SELECT * FROM accounts_cart WHERE email_acc=? AND id=?";
		Connection Conn = MySQLConnect.GetConnect();
		try (PreparedStatement State = Conn.prepareStatement(Query)) {
			State.setString(1, Email);
			State.setString(2, Id);
			ResultSet Result = State.executeQuery();
			while (Result.next()) {
				IdCart.add(Result.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (IdCart.isEmpty()) {
			setCheck(true);
		} else {
			for (int i = 0; i < IdCart.size(); i++) {
				if (IdCart.get(i).equals(Id)) {
					setCheck(false);
				}
			}
		}

		return isCheck();
	}
}
