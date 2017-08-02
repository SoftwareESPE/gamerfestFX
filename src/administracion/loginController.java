/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;


import clases.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static administracion.InicioController.myController;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import servicios.Conexion;
import static servicios.Conexion.obtener;
import administracion.ControledScreen;
import static servicios.Operacion.recuperarUsu;
import administracion.ScreenControled;


/**
 *
 * @author josue
 */
public class loginController implements Initializable, ControledScreen {
    
    private ScreenControled myController;
    public static ScreenControled myControllers;
    
    public void setScreenParent(ScreenControled screenParent){
        myController = screenParent;
    }
    
    @FXML
    private JFXTextField txt_usu;

    @FXML
    private JFXPasswordField txt_contra;

    @FXML
    private JFXButton btn_ingre;
    
    
    @FXML
    void ingresarSistema(ActionEvent event) {
        String usuario, contraseña;
        boolean valor = true;
        usuario = txt_usu.getText();
        contraseña = txt_contra.getText();
        Usuario usu = null;
        try {
            usu = recuperarUsu(obtener(), usuario);
        } catch (Exception ex) {
            valor = false;
            System.err.println("Error al recuperar datos");
        }  
        if(valor)
            if(usuario.compareTo(usu.getCedula())== 0)
                if(contraseña.compareTo(usu.getContraseña())==0){
                    SuperAdminController.myController.setScreen(InicioController.screen1ID);
                }                  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myControllers = myController;
    }    

   
    
}
