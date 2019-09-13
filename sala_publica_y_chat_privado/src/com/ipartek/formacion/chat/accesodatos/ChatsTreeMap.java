package com.ipartek.formacion.chat.accesodatos;

import java.sql.PreparedStatement;
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
			String sql = "SELECT c.id, c.chat, c.fecha, c.idUsuario, u.nombre FROM chats c , usuarios u where c.idUsuario = u.id";
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
					chats.put(rs.getLong("id"), new Chats(rs.getLong("id"), rs.getString("chat"), rs.getDate("fecha"), rs.getLong("idUsuario"), rs.getString("nombre")));
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
		insertarBd(chats.get(id));
	}

	private void insertarBd(Chats chat) {
		//c.id, c.chat, c.fecha, c.idUsuario
		String sql = "INSERT INTO chats (chat,fecha,idUsuario) VALUES(?,?,?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, chat.getTexto());
			ps.setDate(2,chat.getFecha() );
			ps.setLong(3, chat.getIdUsuario());
			
			
			
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
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
