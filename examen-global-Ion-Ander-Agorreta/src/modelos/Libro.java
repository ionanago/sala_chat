package modelos;

import java.math.BigDecimal;

public class Libro {
	private String titulo;
	private String autor;
	private long isbn;
	private BigDecimal precio;
	private BigDecimal precioAntes;
	private int descuento;
	private int img;
	
	

	public Libro(String titulo, String autor, long isbn,int img, BigDecimal precio, BigDecimal precioAntes, int descuento) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.precio = precio;
		this.precioAntes = precioAntes;
		this.descuento = descuento;
		this.img=img;
		
	}
	
	
	
	
	public Libro(String titulo, String autor, Long isbn) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		
		
	}
	public Libro(String titulo, String autor, Long isbn,int img) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.setImg(img);
		
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public String getAutor() {
		return autor;
	}




	public void setAutor(String autor) {
		this.autor = autor;
	}




	public long getIsbn() {
		return isbn;
	}




	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}




	public BigDecimal getPrecio() {
		return precio;
	}




	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}




	public BigDecimal getPrecioAntes() {
		return precioAntes;
	}




	public void setPrecioAntes(BigDecimal precioAntes) {
		this.precioAntes = precioAntes;
	}




	public int getDescuento() {
		return descuento;
	}




	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}




	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}




	public int getImg() {
		return img;
	}




	public void setImg(int img) {
		this.img = img;
	}
	
	
	
}
