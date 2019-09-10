package com.ipartek.formacion.chat.accesodatos;


	public interface CrudAble<T> {
		Iterable<T> getAll();
		T getById(Long id);
		
		void insert(T o);
		void update(T o);
		void delete(Long id);
	}


