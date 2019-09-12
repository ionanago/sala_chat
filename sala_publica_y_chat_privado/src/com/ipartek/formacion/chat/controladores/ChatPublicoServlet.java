package com.ipartek.formacion.chat.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.chat.modelo.Chats;
import com.ipartek.formacion.chat.modelo.Usuarios;
import com.ipartek.formacion.chat.servicios.ChatServicioImpl;


@WebServlet("/chat")
public class ChatPublicoServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Iterable<Usuarios> usuarios = ChatServicioImpl.getInstancia().devolverUsuarios();
		Iterable<Chats> chats = ChatServicioImpl.getInstancia().devolverChats();
		//System.out.println(chats);
		System.out.println(usuarios);
		request.setAttribute("usuarios", usuarios);
		
		request.setAttribute("chats", chats);
		
		
			
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

