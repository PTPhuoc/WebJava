package com.inventory;

import java.util.Objects;

public class Product {
	private String id;
	private String image_pd;
	private String name_pd;
	private String type_pd;
	private Double price_pd;
	private String producer_pd;
	public Product(String id, String image_pd, String name_pd, String type_pd, Double price_pd, String producer_pd) {
		super();
		this.id = id;
		this.image_pd = image_pd;
		this.name_pd = name_pd;
		this.type_pd = type_pd;
		this.price_pd = price_pd;
		this.producer_pd = producer_pd;
	}
	public Product() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage_pd() {
		return image_pd;
	}
	public void setImage_pd(String image_pd) {
		this.image_pd = image_pd;
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
	public Double getPrice_pd() {
		return price_pd;
	}
	public void setPrice_pd(Double price_pd) {
		this.price_pd = price_pd;
	}
	public String getProducer_pd() {
		return producer_pd;
	}
	public void setProducer_pd(String producer_pd) {
		this.producer_pd = producer_pd;
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
