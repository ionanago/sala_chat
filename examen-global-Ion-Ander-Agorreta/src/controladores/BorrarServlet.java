package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accesoadatos.ColeccionLibros;
import modelos.Libro;


@WebServlet("/BorrarServlet")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTAS_ADMIN_JSP = "/adminServlet";  
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher requestDispatcheradmin = request.getRequestDispatcher(VISTAS_ADMIN_JSP);
		String tit = request.getParameter("titulo");
		String aut = request.getParameter("autor");
		String isbn =request.getParameter("isbn");
		String img = request.getParameter("img");
		
		Libro libroaborrar = new Libro(tit,aut,(Long)Long.parseLong(isbn),Integer.parseInt(img));
		ColeccionLibros libros = ColeccionLibros.getInstance();
		libros.eliminar(libroaborrar);
		
		requestDispatcheradmin.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
