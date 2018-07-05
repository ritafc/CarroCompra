package com.rita.database;

import java.util.ArrayList;
import java.util.List;

import com.rita.models.Almacen;
import com.rita.models.Item;
import com.rita.models.Pedido;
import com.rita.models.Usuario;
public class DataBase {
	private static DataBase Instancia=null;
	private static List<Usuario> listaUsuario =new ArrayList<>();
	private static List<Pedido> listaPedido =new ArrayList<>();
	private static Almacen miAlmacen = null;
	
	public static final DataBase getInstancia() {
		if(Instancia == null) Instancia=new DataBase();
		return Instancia;
	}
	private DataBase() {
		CargarUsuario();
		CargarItems();
	}
	
	private static final boolean CargarUsuario() {
		listaUsuario.add(new Usuario("Ricardo","ri@goo.pe","123",40,"1"));
		listaUsuario.add(new Usuario("Rita","ri@goo.bo","123",38,"2"));
		return true;
	}
	
	private static final boolean CargarItems() {
		miAlmacen= new Almacen();
		return true;
		 
	}
	public int crearPedido(Usuario unUsuario) {
		
		int idNuevoPedido=0;
		if(listaPedido.size()>0) {
			idNuevoPedido=listaPedido.get(listaPedido.size()-1).getIdPedido()+1;
		}
		listaPedido.add(new Pedido(idNuevoPedido,unUsuario));
		return idNuevoPedido;
	}
	
	public Pedido getPedido(String email) {
		Pedido miPedido=null;
		for (Pedido unPedido : listaPedido) {
			if(unPedido.getCliente().getEmail().equals(email)) {
				miPedido=unPedido;
				break;
			}
		}
		return miPedido;
	}
	
	public final boolean updatePedido(int idPedido, Item unItem) {
		
		for (int i=0; i<listaPedido.size();i++) {
			if(listaPedido.get(i).getIdPedido()==idPedido) {
				listaPedido.get(i).añadirItem(unItem);
				break;
			}
		}
		return true;
	}
	
	public Usuario getUsuario(String email,String pass) {
		Usuario unUsuario=null;
		for (Usuario unUsu : listaUsuario) {
			if(unUsu.getEmail().equals(email)  && unUsu.getPassword().equals(pass)) {
				unUsuario=unUsu;
				break;
			}
		}
		return unUsuario;
	}
	
	public Usuario getUsuarioActivo(String email) {
		Usuario unUsuario=null;
		for (Usuario unUsu : listaUsuario) {
			if(unUsu.getEmail().equals(email)) {
				unUsuario=unUsu;
				break;
			}
		}
		return unUsuario;
	}
	
	public List<Item> getItemsAlmacen(){
		return this.miAlmacen.mostrar_Items_Almacen();
		
	}
	public Almacen getAlmacen(){
		return this.miAlmacen;
		
	}
	
	
	
}
