package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.MySQL.MySQLConnect;

public class ShowHistoryBuy {
	public List<History> GetHistory(String Email) throws Exception{
		List<History> HistoryBuy = new ArrayList<History>();
		Connection Conn = MySQLConnect.GetConnect();
		String Query = "SELECT * FROM accounts_history WHERE email_acc=?";
		try (PreparedStatement State = Conn.prepareStatement(Query)){
			State.setString(1, Email);
			ResultSet Result = State.executeQuery();
			while(Result.next()) {
				History H = new History();
				H.setId(Result.getString("id"));
				H.setEmail_acc(Result.getString("email_acc"));
				H.setName_pd(Result.getString("name_pd"));
				H.setQuantity(Result.getInt("quantity"));
				H.setType_pd(Result.getString("type_pd"));
				H.setDate_buy(Result.getDate("date_buy").toLocalDate());
				HistoryBuy.add(H);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HistoryBuy;
	}
}
