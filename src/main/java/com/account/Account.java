package com.account;

import java.time.LocalDate;

public class Account {
	private String email_acc;
	private String name_acc;
	private String role_acc;
	private double money_acc;
	private LocalDate date_create_acc;
	public Account(String email_acc, String name_acc, String role_acc, double money_acc, LocalDate date_create_acc) {
		super();
		this.email_acc = email_acc;
		this.name_acc = name_acc;
		this.role_acc = role_acc;
		this.money_acc = money_acc;
		this.date_create_acc = date_create_acc;
	}
	public Account() {
		super();
	}
	public String getEmail_acc() {
		return email_acc;
	}
	public void setEmail_acc(String email_acc) {
		this.email_acc = email_acc;
	}
	public String getName_acc() {
		return name_acc;
	}
	public void setName_acc(String name_acc) {
		this.name_acc = name_acc;
	}
	public String getRole_acc() {
		return role_acc;
	}
	public void setRole_acc(String role_acc) {
		this.role_acc = role_acc;
	}
	public double getMoney_acc() {
		return money_acc;
	}
	public void setMoney_acc(double money_acc) {
		this.money_acc = money_acc;
	}
	public LocalDate getDate_create_acc() {
		return date_create_acc;
	}
	public void setDate_create_acc(LocalDate date_create_acc) {
		this.date_create_acc = date_create_acc;
	}
	
}
