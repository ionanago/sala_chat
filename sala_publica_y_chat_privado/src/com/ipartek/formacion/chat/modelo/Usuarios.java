package com.ipartek.formacion.chat.modelo;

public class Usuarios {
private long id;
private String nombre;
private String password;


private String errorId, errorNombre;
private boolean error = false;

public Usuarios(long id, String nombre,String password) {
	
	setId(id);
	setNombre(nombre);
	setPassword(password);
}
public Usuarios(String nombre , String password) {
	this(null, nombre, password);
}


public Usuarios(String id, String nombre, String password) {
	try {
		Long l = Long.parseLong(id);
		setId(l);
	} catch (NumberFormatException e) {
		setErrorId("El id DEBE ser un número");
	}
	setNombre(nombre);
	setPassword(password);
}



public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPassword() {
	
	return password;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
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
	Usuarios other = (Usuarios) obj;
	if (id != other.id)
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
	return "usuarios [id=" + id + ", nombre=" + nombre + "]";
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

public void setErrorDescripcion(String  errorNombre) {
	setError(true);
	this. errorNombre =  errorNombre;
}






}
