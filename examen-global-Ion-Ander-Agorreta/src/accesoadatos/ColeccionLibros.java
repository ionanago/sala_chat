package accesoadatos;


import modelos.Libro;
import modelos.ModeloException;

import java.math.BigDecimal;
import java.util.ArrayList;






public class ColeccionLibros implements Crudable<Libro> {
	
	
	
public ColeccionLibros() {
	}

	private static ColeccionLibros instancia;
	private static ArrayList<Libro> libros = new ArrayList<Libro>();
	
	public int indicearray;

	
	public static ColeccionLibros getInstance() {
		if(instancia == null) {
			instancia = new ColeccionLibros();
			libros.add(new Libro(1,"libro1","pepe",(long) 123456,1,new BigDecimal("5.65"),new BigDecimal("13.00"),5));
			libros.add(new Libro(2,"libro2","lucas",(long)223456,2,new BigDecimal("6.65"),new BigDecimal("14.00"),25));
			libros.add(new Libro(3,"libro3","luis",(long)323456,3,new BigDecimal("52.35"),new BigDecimal("17.00"),2));
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
	public void eliminar(int id) {
		
		System.out.println(id);
		libros.remove(buscarPorId(id));
	}

	@Override
	public void modificar(Libro objeto) {
		
		
	}
	public int buscarPorId(int id){
		indicearray = 0;
		while(indicearray < libros.size()-1) {
			if( indicearray + 1 == id)  {
				break;
			}
			indicearray++;
		}
		return indicearray;
	}

}
