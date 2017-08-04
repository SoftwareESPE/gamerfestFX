/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;
import java.sql.*;

import javax.swing.JOptionPane;
public class ConexionMySQL {

	public String db = "mydb";
	public String url = "jdbc:mysql://localhost/"+db;
	public String user="root";
	public String pass="";
	
	public ConexionMySQL(){
		
	}
	
	public Connection Conectar(){
		Connection link=null;
		try{
			//Cargar el Diver MySql
			Class.forName("com.mysql.jdbc.Driver");
			//Crear un enlace hacia la base de datos
			link=DriverManager.getConnection(url,user,pass);
		} catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, e);
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, ex);
		}
		return link;
	}
}