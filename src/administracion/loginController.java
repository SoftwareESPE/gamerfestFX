/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;


import static administracion.InicioController.mainContainer;
import clases.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import static servicios.Conexion.obtener;
import static servicios.Operacion.recuperarUsu;
import static servicios.Validacion.validarNumero;


public class loginController implements Initializable, ControledScreen {
    
    private ScreenControled myController;
    public static ScreenControled myControllers;
    
    public void setScreenParent(ScreenControled screenParent){
        myController = screenParent;
    }
    
    private static Usuario usu ;
    
    @FXML
    private JFXTextField txt_usu;

    @FXML
    private JFXPasswordField txt_contra;

    @FXML
    private JFXButton btn_ingre;
    
    @FXML
    private Label lbl_mensaje;
    
    @FXML
    void ingresarSistema(ActionEvent event) throws InterruptedException {
        String usuario, contraseña;
        boolean valor = false;
        if(!txt_usu.getText().isEmpty()){
            usuario = txt_usu.getText();
            contraseña = txt_contra.getText();
            try {
                usu = recuperarUsu(obtener(), usuario);
            } catch (Exception ex) {
                valor = false;
                System.err.println("Error al recuperar datos");
            }
            if(usu.getCedula() != null)
                if(contraseña.compareTo(usu.getContraseña())==0){
                    if(usu.getTipo()==1){
                        mainContainer.loadScreen(InicioController.screen1ID, InicioController.screen1File);
                        SuperAdminController.myController.setScreen(InicioController.screen1ID);
                    }
                    else if(usu.getTipo()==2){
                        mainContainer.loadScreen(InicioController.screen2ID, InicioController.screen2File);
                        AdminController.myController.setScreen(InicioController.screen2ID);
                    }
                    else if(usu.getTipo()==3){
                        mainContainer.loadScreen(InicioController.screen3ID, InicioController.screen3File);
                        PrincipalOrganizadoresController.myController.setScreen(InicioController.screen3ID);
                    }
                        
                    valor = true;
                }
        }
        if(!valor)
            this.lbl_mensaje.setVisible(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myControllers = myController;
        validarNumero(this.txt_usu);
    }  
    
    @FXML
    void ocultarMensaje1(MouseEvent event) {
        if(this.lbl_mensaje.isVisible())
            this.lbl_mensaje.setVisible(false);
    }

    @FXML
    void ocultarMensaje2(MouseEvent event) {
        if(this.lbl_mensaje.isVisible())
            this.lbl_mensaje.setVisible(false);
    }
    
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        loginController.usu = usu;
    }
}
