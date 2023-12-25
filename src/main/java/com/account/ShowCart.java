package com.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.MySQL.MySQLConnect;

public class ShowCart {
	public List<Cart> GetAllCart(String Email) throws Exception{
		List<Cart> CartUser = new ArrayList<Cart>();
		String Query = "SELECT * FROM accounts_cart WHERE email_acc=?;";
		Connection Conn = MySQLConnect.GetConnect();
		try(PreparedStatement State = Conn.prepareStatement(Query)) {
			State.setString(1, Email);
			ResultSet Result = State.executeQuery();
			while(Result.next()) {
				Cart C = new Cart();
				C.setId(Result.getString("id"));
				C.setEmail_acc(Result.getString("email_acc"));
				C.setQuantity(Result.getInt("quantity"));
				C.setName_pd(Result.getString("name_pd"));
				C.setType_pd(Result.getString("type_pd"));
				CartUser.add(C);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CartUser;
	}
}
