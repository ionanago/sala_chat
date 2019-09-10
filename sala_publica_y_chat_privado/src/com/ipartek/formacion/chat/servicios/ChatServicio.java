package com.ipartek.formacion.chat.servicios;

import com.ipartek.formacion.chat.modelo.Chats;
import com.ipartek.formacion.chat.modelo.Usuarios;;

public interface ChatServicio {

	Iterable<Chats> devolverChats();
	Iterable<Usuarios> devolverUsuarios();
	
	
	
}
