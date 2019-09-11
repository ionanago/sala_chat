package com.ipartek.formacion.chat.accesodatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.ipartek.formacion.chat.modelo.Usuarios;


public class UsuariosTreeMap  extends Conexion implements UsuariosCrudAble  {

	
private static UsuariosTreeMap instancia = new UsuariosTreeMap();
	
	public static UsuariosTreeMap getInstancia() {
		return instancia;
	}
	
	
	
	
	
	private TreeMap<Long, Usuarios> usuarios = new TreeMap<>();
	
	
	
	
	
	public ResultSet recorrerbd(){
		ResultSet rs=null;
		Statement s=null;
		try {
			s = super.con.createStatement();
			String sql = "SELECT * FROM usuarios";
			//SELECT * FROM libreria_1.libros;
			 rs = s.executeQuery(sql);
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
			return rs;
		
		}
	
	
	
	public void borrarID(long id) {
		String sql = "DELETE FROM libros WHERE id=?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void actualizarUsuario(Usuarios usuario) {
		String sql = "UPDATE usuarios SET nombre,password WHERE id=?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getPassword());
			ps.setLong(3, usuario.getId());
			
			
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	private void addUsuario(Usuarios usuario){
		String sql = "INSERT INTO usuarios (nombre,password) VALUES(?,?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getPassword());
			
			
			
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	private UsuariosTreeMap() {
		ResultSet rs = recorrerbd();
		try {
			while(rs.next()) {
				try {
					usuarios.put(rs.getLong("id"), new Usuarios(rs.getLong("id"), rs.getString("nombre"), rs.getString("password")));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
//		logins.put(1L, new Login(1L, "javier@email.net", "contra"));
//		logins.put(2L, new Login(2L, "pepe@email.net", "perez"));
	}

	@Override
	public Iterable<Usuarios> getAll() {
		return usuarios.values();
	}

	@Override
	public Usuarios getById(Long id) {
		return usuarios.get(id);
	}

	@Override
	public void insert(Usuarios usuario) {
		Long id = usuarios.lastKey() + 1;
		usuario.setId(id);
		usuarios.put(id, usuario);
		addUsuario(usuario);
	}

	@Override
	public void update(Usuarios usuario) {
		usuarios.put(usuario.getId(), usuario);
		actualizarUsuario(usuario);
	}

	@Override
	public void delete(Long id) {
		
		
		usuarios.remove(id);
		borrarID(id);
	}

	@Override
	public Usuarios getByName(String nombre) {
		
		for(Usuarios usuario: getAll()) {
			if(nombre.equals(usuario.getNombre())) {
				return usuario;
			}
		}
		
		return null;
	}
	
	
}
