


	package com.ipartek.formacion.chat.accesodatos;
	import java.sql.*;

	public class Conexion {
		
		
		private String user="root";
		private String passwd="admin";
		protected Connection con =null;
		 public  Conexion(){
			 
			 try {
				 new com.mysql.cj.jdbc.Driver();
				 String uri = "jdbc:mysql://localhost:3307/chat?serverTimezone=UTC";
				 con = DriverManager.getConnection(uri, user , passwd);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			 
		 }}

