package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckEmail {
	private static boolean Check = true;

	public static boolean isCheck() {
		return Check;
	}

	public static void setCheck(boolean check) {
		CheckEmail.Check = check;
	}

	public static boolean CheckEmailExists(String Email, Connection Conn) throws Exception {
		String Query = "SELECT COUNT(*) AS count FROM accounts WHERE email_acc=?";
		try (PreparedStatement State = Conn.prepareStatement(Query)) {
			State.setString(1, Email);
			ResultSet Result = State.executeQuery();
			if (Result.next()) {
                int count = Result.getInt("count");
                setCheck(count == 0);
            } else {
                setCheck(false);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCheck();
	}
}
