package com.ipartek.formacion.chat.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.chat.accesodatos.ChatsTreeMap;
import com.ipartek.formacion.chat.accesodatos.UsuariosTreeMap;
import com.ipartek.formacion.chat.modelo.Chats;



@WebServlet("/enviarChat1")
public class EviarChat1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   


	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		ChatsTreeMap chattrmp	= ChatsTreeMap.getInstancia();	
		UsuariosTreeMap usutrmao = UsuariosTreeMap.getInstancia();
		
		Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
		
		String nombreUsuario= usutrmao.getById(idUsuario).getNombre();
		
		String texto = request.getParameter("texto");
		
		Long millis=System.currentTimeMillis();
		java.sql.Date fecha=new java.sql.Date(millis);
		
		
		Chats chat = new Chats(texto, fecha, idUsuario, nombreUsuario);
		
		chattrmp.insert(chat);
		
	//	 Chats(String texto, Date fecha, Long idUsuario , String nombreUsuario)
		
		
		
		request.getRequestDispatcher("/chat").forward(request, response);
	}
		
	

}
