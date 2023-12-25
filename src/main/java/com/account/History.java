package com.account;

import java.time.LocalDate;

public class History {
	private String id;
	private String email_acc;
	private int quantity;
	private String name_pd;
	private String type_pd;
	private LocalDate date_buy;
	public History(String id, String email_acc, int quantity, String name_pd, String type_pd, LocalDate date_buy) {
		super();
		this.id = id;
		this.email_acc = email_acc;
		this.quantity = quantity;
		this.name_pd = name_pd;
		this.type_pd = type_pd;
		this.date_buy = date_buy;
	}
	public History() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail_acc() {
		return email_acc;
	}
	public void setEmail_acc(String email_acc) {
		this.email_acc = email_acc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName_pd() {
		return name_pd;
	}
	public void setName_pd(String name_pd) {
		this.name_pd = name_pd;
	}
	public String getType_pd() {
		return type_pd;
	}
	public void setType_pd(String type_pd) {
		this.type_pd = type_pd;
	}
	public LocalDate getDate_buy() {
		return date_buy;
	}
	public void setDate_buy(LocalDate date_buy) {
		this.date_buy = date_buy;
	}
	
}
