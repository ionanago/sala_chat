package com.ipartek.formacion.chat.accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.ipartek.formacion.chat.modelo.Chats;

public class ChatsTreeMap extends Conexion implements ChatsCrudAble{
	
	
	
private static ChatsTreeMap instancia = new ChatsTreeMap();
	
	public static ChatsTreeMap getInstancia() {
		return instancia;
	}
	
	private TreeMap<Long, Chats> chats = new TreeMap<>();
	public ResultSet recorrerbd(){
		ResultSet rs=null;
		Statement s=null;
		try {
			s = super.con.createStatement();
			String sql = "SELECT * FROM chat.chats";
			//SELECT * FROM libreria_1.libros;
			 rs = s.executeQuery(sql);
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
			return rs;
		
		}
	
	private ChatsTreeMap() {
		ResultSet rs = recorrerbd();
		try {
			while(rs.next()) {
				try {
					chats.put(rs.getLong("id"), new Chats(rs.getLong("id"), rs.getString("texto"), rs.getDate("fecha"), rs.getLong("idUsuario")));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	

	@Override
	public Iterable<Chats> getAll() {
		return chats.values();
	}

	@Override
	public Chats getById(Long id) {
		return chats.get(id);
	}

	@Override
	public void insert(Chats chat) {
		Long id = chats.lastKey() + 1;
		chat.setId(id);
		chats.put(id, chat);
	}

	@Override
	public void update(Chats chat) {
		chats.put(chat.getId(), chat);
	}

	@Override
	public void delete(Long id) {
		chats.remove(id);
	}

}
