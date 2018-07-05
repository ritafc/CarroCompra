package com.rita.models;


import java.util.ArrayList;
import java.util.List;


public class Almacen {

	private List<Item>  listaItems = new ArrayList();
		
	public Almacen() {
		listaItems.add( new Item(1, "Camisetas", 10,5));
		listaItems.add( new Item(2, "Pantalon", 30,5));
		listaItems.add( new Item(3, "Vestido", 50,5));
		listaItems.add( new Item(4, "Chaqueta", 80,5));
		listaItems.add( new Item(5, "Zapatos", 100,5));
		listaItems.add( new Item(6, "Bolso", 30,5));
		listaItems.add( new Item(7, "Cinturon", 10,5));
		listaItems.add(new Item(8, "Libro", 20,5));
		listaItems.add( new Item(9, "Agua", 1,5));
		listaItems.add(new Item(10, "Cds", 1,5));
		listaItems.add( new Item(11, "Sombrero", 10,5));
		listaItems.add( new Item(12, "Comic", 2,5));
	}

	public Item get_Item_Almacen (int idItem) {
		Item unItem=null;
		for (Item item : listaItems) {
			if(item.getId_Item()==idItem) {
				unItem=item;
				break;
			}
		}
		return unItem;
	}
		
	
	public List<Item> mostrar_Items_Almacen() {
		 return this.listaItems;
	}
	
	public void sustraerItem(Item unItem) {
			unItem.restarStock();
		
	}

	public void anadirItem(Item unItem) {
			unItem.aumentaStock();
		
	}
}