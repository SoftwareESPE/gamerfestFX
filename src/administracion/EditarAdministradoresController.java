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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import static servicios.Conexion.obtener;
import static servicios.Operacion.actualizarAdmi;

public class EditarAdministradoresController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField txtf_nombre;

    @FXML
    private JFXTextField txtf_Apellido;

    @FXML
    private JFXTextField txtf_Cedula;

    @FXML
    private JFXPasswordField txtf_Contra;

    @FXML
    private JFXButton btn_guardad;
     @FXML
    void Guardar(ActionEvent event) throws FileNotFoundException {
        Usuario usua = getUsu();
        usua.setApellido(this.txtf_Apellido.getText());
        usua.setCedula(this.txtf_Cedula.getText());
        usua.setNombre(this.txtf_nombre.getText());
        usua.setContraseña(this.txtf_Contra.getText());
        try {
            actualizarAdmi(obtener(), usua);
        } catch (Exception ex) {
            System.err.println("Error al guardar");;
        }
    }
    
    @FXML
    void activarBoton(KeyEvent event) {
        if(this.txtf_nombre.getText().isEmpty() || this.txtf_Apellido.getText().isEmpty() || this.txtf_Cedula.getText().isEmpty() || this.txtf_Contra.getText().isEmpty())
            this.btn_guardad.setDisable(true);
        else
            this.btn_guardad.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.btn_guardad.setDisable(true);
        Usuario usu = getUsu();
        if(usu.getTipo()==2){
            this.txtf_nombre.setText(usu.getNombre());
            this.txtf_Apellido.setText(usu.getApellido());
            this.txtf_Cedula.setText(usu.getCedula());
            this.txtf_Contra.setText(usu.getContraseña());
        }
    }    
    
}
