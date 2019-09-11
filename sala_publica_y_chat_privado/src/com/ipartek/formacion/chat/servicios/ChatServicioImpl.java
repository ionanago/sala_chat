package com.ipartek.formacion.chat.servicios;

import com.ipartek.formacion.chat.accesodatos.ChatsTreeMap;
import com.ipartek.formacion.chat.accesodatos.UsuariosTreeMap;
import com.ipartek.formacion.chat.modelo.Chats;
import com.ipartek.formacion.chat.modelo.Usuarios;

public class ChatServicioImpl implements ChatServicio {
	
	
	private static ChatServicioImpl ChatServicioImpl = new ChatServicioImpl();
private ChatServicioImpl() {}
	
	public static ChatServicioImpl getInstancia() { return ChatServicioImpl; }
	

	@Override
	public Iterable<Chats> devolverChats() {
		return ChatsTreeMap.getInstancia().getAll();
	}

	@Override
	public Iterable<Usuarios> devolverUsuarios() {
		return UsuariosTreeMap.getInstancia().getAll();
	}

}
