package com.rita.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rita.database.DataBase;
import com.rita.models.Item;
import com.rita.models.Usuario;

/**
 * Servlet implementation class micarroServlet
 */
@WebServlet("/micarro")
public class micarroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(session.getAttribute("email")!=null) {
			String email=(String)session.getAttribute("email");
			System.out.println("entro antes de obtener la lista");
			List<Item> listamiPedido=DataBase.getInstancia().getPedido(email).getMisPedidos();
			Usuario usuarioActivo= DataBase.getInstancia().getUsuarioActivo(email);
			request.setAttribute("usuarioActivo", usuarioActivo);
			request.setAttribute("listamisItem", listamiPedido);
			request.getRequestDispatcher("micarro.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
