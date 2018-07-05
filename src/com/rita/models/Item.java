package com.rita.models;

public class Item {
	private int id_Item;
	private String nombre;
	private double precio;
	private int stock;
	
	public Item(int id_Item, String nombre, double precio, int stock) {
		this.id_Item = id_Item;
		this.nombre = nombre;
		this.precio = precio;
	}
	

	
public int getId_Item() {
		return id_Item;
	}



	public void setId_Item(int id_Item) {
		this.id_Item = id_Item;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



public void restarStock() {
	this.stock-=1;
}

public void aumentaStock() {
	this.stock+=1;
}


}
