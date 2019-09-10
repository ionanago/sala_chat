package com.ipartek.formacion.chat.servicios;

import com.ipartek.formacion.chat.accesodatos.UsuariosTreeMap;
import com.ipartek.formacion.chat.modelo.Usuarios;

public class UsuariosServicioImpl implements UsuariosServicio {

	private static UsuariosServicioImpl UsuarioServicioImpl = new UsuariosServicioImpl();
	
	private UsuariosServicioImpl() {}
	
	public static UsuariosServicioImpl getInstancia() { return UsuarioServicioImpl; }
	
	@Override
	public boolean autenticar(Usuarios usuario) {
		Usuarios encontrado = UsuariosTreeMap.getInstancia().getByName(usuario.getNombre());
		
		return encontrado != null && encontrado.getPassword().equals(usuario.getPassword());
	}
	
	

}
