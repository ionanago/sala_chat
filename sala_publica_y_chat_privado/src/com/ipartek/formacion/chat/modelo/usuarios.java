package com.ipartek.formacion.chat.modelo;

public class usuarios {
private long id;
private String nombre;


public usuarios(long id, String nombre) {
	super();
	setId(id);
	setNombre(nombre);
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
	usuarios other = (usuarios) obj;
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







}
