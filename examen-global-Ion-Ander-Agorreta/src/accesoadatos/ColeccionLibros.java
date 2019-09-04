package accesoadatos;


import modelos.Libro;
import modelos.ModeloException;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;




public class ColeccionLibros implements Crudable<Libro> {
	
	
	
public ColeccionLibros() {
		
	}
	private static ColeccionLibros instancia;
	private static ArrayList<Libro> libros = new ArrayList<Libro>();
	public static ColeccionLibros getInstance() {
		if(instancia == null) {
			instancia = new ColeccionLibros();
			libros.add(new Libro("libro1","pepe",(long) 123456,1));
			libros.add(new Libro("libro2","lucas",(long)223456,2,new BigDecimal(55.65),new BigDecimal(17.00),25));
			libros.add(new Libro("libro3","luis",(long)323456,3));
			//libros.add(new Libro("titulo4","autor4",(long)15689),new BigDecimal(17.95),new BigDecimal(17.00),5);
		}
		
		return instancia;
	}
	

	@Override
	public Iterable<Libro> getAll() {
		
		return libros;
	}

	@Override
	public Libro getOne(long isbn) {
		
		return null;
	}

	@Override
	public void insertar(Libro objeto) {
		libros.add(objeto);
		
	}

	@Override
	public void eliminar(Libro libro) {
		
		
		if(!libros.contains(libro)){
			throw new ModeloException("libro no existente");
		}
		
		libros.remove( libro);
		
	}

	@Override
	public void modificar(Libro objeto) {
		
		
	}

}
