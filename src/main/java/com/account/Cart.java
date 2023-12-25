package com.account;

public class Cart {
	private String id;
	private String email_acc;
	private int quantity;
	private String name_pd;
	private String type_pd;
	public Cart(String id, String email_acc, int quantity, String name_pd, String type_pd) {
		super();
		this.id = id;
		this.email_acc = email_acc;
		this.quantity = quantity;
		this.name_pd = name_pd;
		this.type_pd = type_pd;
	}
	public Cart() {
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
	
}
