package com.rita.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;


import com.rita.database.DataBase;
import com.rita.models.Almacen;
import com.rita.models.Item;
import com.rita.models.Pedido;
import com.rita.models.Usuario;

/**
 * Servlet implementation class principalServlet
 */
@WebServlet("/principal")
public class principalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(session.getAttribute("email")!=null) {
			List<Item> listaItems=DataBase.getInstancia().getItemsAlmacen();
			Usuario usuarioActivo= DataBase.getInstancia().getUsuarioActivo((String)session.getAttribute("email"));
			request.setAttribute("usuarioActivo", usuarioActivo);
			request.setAttribute("listaItem", listaItems);
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(session.getAttribute("email")!=null ) {
			int idItem=request.getParameter("id_Item")!=null?Integer.parseInt(request.getParameter("id_Item")):0;
			
			if(session.getAttribute("idPedido")!=null) {
				int idPedido=(Integer)(session.getAttribute("idPedido"));
				Item unItem =DataBase.getInstancia().getAlmacen().get_Item_Almacen(idItem);
				DataBase.getInstancia().updatePedido(idPedido, unItem);
				System.out.println(unItem.getId_Item());
			}
			doGet(request, response);
		}else {
			response.sendRedirect("login");
		}
		
		
	}

}
