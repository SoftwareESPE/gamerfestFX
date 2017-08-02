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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Marco Macias
 */
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
    void Guardar(ActionEvent event) {
        Usuario usu = new Usuario();    
        usu.setApellido(this.txtf_Apellido.getText());
        usu.setCedula(this.txtf_Cedula.getText());
        usu.setNombre(this.txtf_nombre.getText());
        usu.setContraseña(this.txtf_Contra.getText());
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
    }    
    
}
