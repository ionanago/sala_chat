package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accesoadatos.*;

import modelos.Libro;

/**
 * Servlet implementation class AñadirServlet
 */
@WebServlet("/AñadirServlet")
public class AñadirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTAS_ADMIN_JSP = "/adminServlet";  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher requestDispatcheradmin = request.getRequestDispatcher(VISTAS_ADMIN_JSP);
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		Long isbn = Long.parseLong(request.getParameter("isbn"));
		int img = Integer.parseInt(request.getParameter("img"));
		if(img==0 || img>4) {img = 1;}
			
			
		Libro nuevoLibro = new Libro(titulo,autor,isbn,img);
		
		 ColeccionLibros libros = ColeccionLibros.getInstance();
		libros.insertar(nuevoLibro);
		
		requestDispatcheradmin.forward(request, response);
		
		
		
		
		
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
