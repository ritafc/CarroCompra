package com.rita.models;

import java.util.ArrayList;

public class Pedido {
	private int idPedido;
	private Usuario cliente;
	private ArrayList<Item> misPedidos= new ArrayList<Item>();
	
	public Pedido(int idPedido, Usuario cliente) {
		this.idPedido = idPedido;
		this.cliente = cliente;
		
	}
	
	public int getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}



	public Usuario getCliente() {
		return cliente;
	}



	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}



	public ArrayList<Item> getMisPedidos() {
		return misPedidos;
	}



	public void setMisPedidos(ArrayList<Item> misPedidos) {
		this.misPedidos = misPedidos;
	}



	public void añadirItem(Item unItem) {
		misPedidos.add(unItem);
		
	}
	
	public void eliminarItem(Item unItem) {
		misPedidos.remove(unItem);
		
	}
	
	public void pagarPedido() {
		for (Item unItem : misPedidos) {
			unItem.restarStock();
		}
		
	}
	

	
}
