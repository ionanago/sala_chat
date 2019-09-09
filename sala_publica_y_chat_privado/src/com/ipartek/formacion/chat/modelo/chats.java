package com.ipartek.formacion.chat.modelo;

import java.sql.Date;

public class chats {

	
	private Long id;
	private String nombre;
	private Date fecha;
	
	private String errorId, errorNombre;
	private boolean error = false;
 chats(Long id, String nombre, Date fecha) {
		
		setId(id);
		setNombre(nombre);
		setFecha(fecha);
		
	}
	
	public chats(String id, String nombre, String fecha) {
		try {
			Long l = Long.parseLong(id);
			setId(l);
		} catch (NumberFormatException e) {
			setErrorId("El id DEBE ser un número");
		}
		setNombre(nombre);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		chats other = (chats) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "chats [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + "]";
	}
	

public boolean isError() {
	return error;
}

private void setError(boolean error) {
	this.error = error;
}

public String getErrorId() {
	return errorId;
}

public void setErrorId(String errorId) {
	setError(true);
	this.errorId = errorId;
}

public String getErroNombre() {
	return errorNombre;
}



	
}


