package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accesoadatos.ColeccionLibros;


@WebServlet("/BorrarServlet")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTAS_ADMIN_JSP = "/adminServlet";  
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher requestDispatcheradmin = request.getRequestDispatcher(VISTAS_ADMIN_JSP);
		String id =request.getParameter("cabra");

		 
		System.out.println(id);
		
		ColeccionLibros libros = ColeccionLibros.getInstance();
		libros.eliminar(Integer.parseInt(id));
		
		requestDispatcheradmin.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
