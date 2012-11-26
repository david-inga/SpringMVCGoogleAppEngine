package com.mkyong.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.googlecode.objectify.Key;


@Entity
public class ProductoVenta {

	
	@Id
	private Long id;
	private Key<Customer> customer;
	private Key<Producto> producto;
	private Date date;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Key<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(Key<Customer> customer) {
		this.customer = customer;
	}
	public Key<Producto> getProducto() {
		return producto;
	}
	public void setProducto(Key<Producto> producto) {
		this.producto = producto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
