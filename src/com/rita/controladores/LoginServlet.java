package com.rita.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.rita.database.DataBase;
import com.rita.models.Usuario;

import javafx.scene.chart.PieChart.Data;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("email")==null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("principal");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("login");
		String pass=request.getParameter("pass");
		Usuario unUsuario = DataBase.getInstancia().getUsuario(email, pass);
		
		
		if(unUsuario!=null) {
			HttpSession session= request.getSession();
			session.setAttribute("email", unUsuario.getEmail());
			
			int idPedido=DataBase.getInstancia().crearPedido(unUsuario);
			session.setAttribute("idPedido", idPedido);
			
			response.sendRedirect("principal");
		}else {
			request.setAttribute("error", "Error al logearte:: login / password incorrectos!!");
			request.setAttribute("unUsuario", unUsuario);
			this.doGet(request, response);
		}
	}

}
