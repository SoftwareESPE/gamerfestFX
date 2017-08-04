/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import static administracion.loginController.getUsu;
import clases.Usuario;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PerfilSuperAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane PanelRoot;
     @FXML
    private Label label_Nombre;

    @FXML
    private Label label_apellido;

    @FXML
    private Label label_cedula;

    @FXML
    private Label label_contra;

    @FXML
    private JFXButton btn_modificar;

    @FXML
    void Modificar(ActionEvent event) {
        try {
           AnchorPane panel = FXMLLoader.load(getClass().getResource("EditarPerfilSuperAdmin.fxml"));
           PanelRoot.getChildren().setAll(panel);
       } catch (IOException ex) {
           Logger.getLogger(SuperAdminController.class.getName()).log(Level.SEVERE, null, ex);
       }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario usu = getUsu();
        this.label_Nombre.setText(usu.getNombre());
        this.label_apellido.setText(usu.getApellido());
        this.label_cedula.setText(usu.getCedula());
        this.label_contra.setText("*************");
    }    
    
}
