package com.mkyong.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@SuppressWarnings("serial")
@Entity
public class Producto implements Serializable{
		
		@Id
		private Long id;
		private String tipo;
		private String nombre;
		private int precio;
		private int stock;
		private int stockOptimo;
		private int Garantia;
		private int margen;
		
		
		public Producto(){
			
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getPrecio() {
			return precio;
		}
		public void setPrecio(int precio) {
			this.precio = precio;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public int getStockOptimo() {
			return stockOptimo;
		}
		public void setStockOptimo(int stockOptimo) {
			this.stockOptimo = stockOptimo;
		}
		public int getGarantia() {
			return Garantia;
		}
		public void setGarantia(int garantia) {
			Garantia = garantia;
		}
		public int getMargen() {
			return margen;
		}
		public void setMargen(int margen) {
			this.margen = margen;
		}
		
		
		
}
