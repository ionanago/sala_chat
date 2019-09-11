package com.ipartek.formacion.chat.modelo;

import java.sql.Date;

public class Chats {

	
	private Long id;
	private String texto;
	private Date fecha;
	private Long idUsuario;
	
	private String errorId, errorTexto;
	private boolean error = false;
	
public Chats(Long id, String texto, Date fecha, Long idUsuario) {
		
		setId(id);
		setTexto(texto);
		setFecha(fecha);
		setIdUsuario(idUsuario);
		
	}
 public Chats(String texto, Date fecha, Long idUsuario) {
		this(null, texto, fecha, idUsuario);
	}
	
	public Chats(String id, String texto, String fecha) {
		try {
			Long l = Long.parseLong(id);
			setId(l);
		} catch (NumberFormatException e) {
			setErrorId("El id DEBE ser un número");
		}
		setTexto(texto);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
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
		Chats other = (Chats) obj;
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
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "chats [id=" + id + ", texto=" + texto + ", fecha=" + fecha + "]";
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

public String getErroTexto() {
	return errorTexto;
}




	
}


