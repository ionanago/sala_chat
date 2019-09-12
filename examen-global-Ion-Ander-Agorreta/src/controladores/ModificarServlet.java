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


@WebServlet("/ModificarServlet")
public class ModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTAS_ADMIN_JSP = "/adminServlet";  
       
   
    public ModificarServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher requestDispatcheradmin = request.getRequestDispatcher(VISTAS_ADMIN_JSP);
		String titulo = request.getParameter("titulom");
		String autor = request.getParameter("autorm");
		Long isbn = Long.parseLong(request.getParameter("isbnm"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		Libro nuevoLibro = new Libro(id,titulo,autor,isbn);
		ColeccionLibros libros = ColeccionLibros.getInstance();
		libros.modificar(nuevoLibro);
		requestDispatcheradmin.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
