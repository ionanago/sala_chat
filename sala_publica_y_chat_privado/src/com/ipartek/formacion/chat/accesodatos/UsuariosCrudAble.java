package com.ipartek.formacion.chat.accesodatos;

import com.ipartek.formacion.chat.modelo.Usuarios;

public interface UsuariosCrudAble  extends CrudAble<Usuarios>{
	
	Usuarios getByName(String nombre);

}
