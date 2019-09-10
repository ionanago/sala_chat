package com.ipartek.formacion.chat.servicios;

import com.ipartek.formacion.chat.modelo.Chats;
public interface ChatServicio {

	Iterable<Chats> getIterable();
	Chats getcChats(Long id);
	
	
}
