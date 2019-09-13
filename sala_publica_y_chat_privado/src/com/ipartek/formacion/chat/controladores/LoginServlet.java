package com.ipartek.formacion.chat.controladores;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.chat.accesodatos.UsuariosTreeMap;
import com.ipartek.formacion.chat.modelo.Usuarios;
import com.ipartek.formacion.chat.servicios.UsuariosServicioImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		
		Usuarios usuario = new Usuarios(nombre, password);
		
		if(UsuariosServicioImpl.getInstancia().autenticar(usuario)) {
			Usuarios usuarioLoged = UsuariosTreeMap.getInstancia().getByName(usuario.getNombre());
			
			
			request.getSession().setAttribute("usuario", usuarioLoged);
			//System.out.println(usuarioLoged);
			request.getRequestDispatcher("/chat").forward(request, response);
		} else {
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}

}