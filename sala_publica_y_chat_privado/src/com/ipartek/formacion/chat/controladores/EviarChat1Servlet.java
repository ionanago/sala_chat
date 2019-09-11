package com.ipartek.formacion.chat.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.chat.servicios.ChatServicio;
import com.ipartek.formacion.chat.servicios.ChatServicioImpl;

/**
 * Servlet implementation class EviarChat1Servlet
 */
@WebServlet("/EviarChat1")
public class EviarChat1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EviarChat1Servlet() {
        super();
            }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		ChatServicio chatservivio	= ChatServicioImpl.getInstancia();	
		
		
		
		
		request.getRequestDispatcher("/chat").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
