package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accesoadatos.ColeccionLibros;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTAS_ADMIN_JSP = "/WEB-INF/vistas/admin.jsp";
   
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher requestDispatcherIndex = request.getRequestDispatcher(VISTAS_ADMIN_JSP);
		ColeccionLibros libros = ColeccionLibros.getInstance();
		request.setAttribute("libros", libros.getAll());
		requestDispatcherIndex.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
