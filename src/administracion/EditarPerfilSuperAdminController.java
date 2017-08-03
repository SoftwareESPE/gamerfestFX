/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import static administracion.loginController.getUsu;
import clases.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import static servicios.Conexion.obtener;
import static servicios.Operacion.actualizarAdmi;

public class EditarPerfilSuperAdminController implements Initializable {
    @FXML
    private AnchorPane PanelRoot;

    @FXML
    private JFXButton btn_guardad;
     @FXML
    private JFXTextField txt_nombre;

    @FXML
    private JFXTextField txt_apellido;

    @FXML
    private JFXTextField txt_cedula_;

    @FXML
    private JFXPasswordField txt_contraseña;

     @FXML
    
    void activarBoton(KeyEvent event) {
        if(this.txt_nombre.getText().isEmpty() || this.txt_apellido.getText().isEmpty() || this.txt_cedula_.getText().isEmpty() || this.txt_contraseña.getText().isEmpty())
            this.btn_guardad.setDisable(true);
        else
            this.btn_guardad.setDisable(false);
    }
    @FXML
    void Guardar(ActionEvent event) {
        Usuario usua = getUsu();
        usua.setApellido(this.txt_apellido.getText());
        usua.setCedula(this.txt_cedula_.getText());
        usua.setNombre(this.txt_nombre.getText());
        usua.setContraseña(this.txt_contraseña.getText());
        try {
            actualizarAdmi(obtener(), usua);
        } catch (Exception ex) {
            System.err.println("Error al guardar");;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario usu = getUsu();
        this.txt_nombre.setText(usu.getNombre());
        this.txt_apellido.setText(usu.getApellido());
        this.txt_cedula_.setText(usu.getCedula());
        this.txt_contraseña.setText(usu.getContraseña());
    }    
    
}
