/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Marco Macias
 */
public class PerfilSuperAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
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

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
