package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.MySQL.MySQLConnect;

public class GetMoneyProduct {
	private double Money;
	
	public double getMoney() {
		return Money;
	}

	public void setMoney(double money) {
		Money = money;
	}

	public double GetMoney(String Id, String Type) throws Exception{
		String Query;
		Connection Conn = MySQLConnect.GetConnect();
		if(Type.equals("CPU")) {
			Query = "SELECT * FROM products_cpu WHERE id=?";
			try (PreparedStatement State = Conn.prepareStatement(Query)){
				State.setString(1, Id);
				ResultSet Result = State.executeQuery();
				if(Result.next()) {
					setMoney(Result.getDouble("price_pd"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(Type.equals("HDD")) {
			Query = "SELECT * FROM products_hdd WHERE id=?";
			try (PreparedStatement State = Conn.prepareStatement(Query)){
				State.setString(1, Id);
				ResultSet Result = State.executeQuery();
				if(Result.next()) {
					setMoney(Result.getDouble("price_pd"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(Type.equals("HeadPhone")) {
			Query = "SELECT * FROM products_headphone WHERE id=?";
			try (PreparedStatement State = Conn.prepareStatement(Query)){
				State.setString(1, Id);
				ResultSet Result = State.executeQuery();
				if(Result.next()) {
					setMoney(Result.getDouble("price_pd"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(Type.equals("Mouse")) {
			Query = "SELECT * FROM products_mouse WHERE id=?";
			try (PreparedStatement State = Conn.prepareStatement(Query)){
				State.setString(1, Id);
				ResultSet Result = State.executeQuery();
				if(Result.next()) {
					setMoney(Result.getDouble("price_pd"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(Type.equals("KeyBroad")) {
			Query = "SELECT * FROM products_keyboard WHERE id=?";
			try (PreparedStatement State = Conn.prepareStatement(Query)){
				State.setString(1, Id);
				ResultSet Result = State.executeQuery();
				if(Result.next()) {
					setMoney(Result.getDouble("price_pd"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(Type.equals("Ram")) {
			Query = "SELECT * FROM products_ram WHERE id=?";
			try (PreparedStatement State = Conn.prepareStatement(Query)){
				State.setString(1, Id);
				ResultSet Result = State.executeQuery();
				if(Result.next()) {
					setMoney(Result.getDouble("price_pd"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(Type.equals("Screens")) {
			Query = "SELECT * FROM products_screens WHERE id=?";
			try (PreparedStatement State = Conn.prepareStatement(Query)){
				State.setString(1, Id);
				ResultSet Result = State.executeQuery();
				if(Result.next()) {
					setMoney(Result.getDouble("price_pd"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			Query = "SELECT * FROM products_vga WHERE id=?";
			try (PreparedStatement State = Conn.prepareStatement(Query)){
				State.setString(1, Id);
				ResultSet Result = State.executeQuery();
				if(Result.next()) {
					setMoney(Result.getDouble("price_pd"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return getMoney();
	}
}
