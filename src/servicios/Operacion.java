/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import clases.Usuario;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author josue
 */
public class Operacion {
    public static Usuario recuperarUsu(Connection conexion, String ci) throws SQLException {
      Usuario per = new Usuario();
      try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT usu_id, usu_nombre, usu_apellido, usu_cedula, usu_contraseña, tipo_usuario_tip_id FROM usuarios WHERE usu_cedula = '"+ci+"'");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){           
                per.setId(resultado.getInt("usu_id"));
                per.setApellido(resultado.getString("usu_apellido"));
                per.setNombre(resultado.getString("usu_nombre"));
                per.setCedula(resultado.getString("usu_cedula"));
                per.setContraseña(resultado.getString("usu_contraseña"));
                per.setTipo(resultado.getInt("tipo_usuario_tip_id"));
                
            }          
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return per;
   }
    
   public void actualizarAdmi(Connection conexion, Usuario per, String ci) throws SQLException, FileNotFoundException{
       String admi = "admin"; 
       try{
            PreparedStatement consulta = null;   
            consulta = conexion.prepareStatement("UPDATE usuarios SET usu_nombre = ?, usu_apellido = ?, usu_cedula = ?, usu_contraseña = ? WHERE usu_cedula = '"+ci+"'");
            consulta.setString(1, per.getNombre());
            consulta.setString(2, per.getApellido());
            consulta.setString(3, per.getCedula());
            consulta.setString(4, per.getContraseña());
            consulta.executeUpdate();
            consulta.close();
        }catch(SQLException ex){
            System.out.println("Error al guardar");
            throw new SQLException(ex);
      }
    }
}
