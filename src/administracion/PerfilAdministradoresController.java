/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import administracion.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Marco Macias
 */
public class PerfilAdministradoresController implements Initializable {

     @FXML
    private JFXTextField txtf_nombre;

    @FXML
    private JFXTextField txtf_Apellido;

    @FXML
    private JFXTextField txtf_Cedula;

    @FXML
    private JFXPasswordField txtf_Contra;

    @FXML
    private JFXButton btn_modificar;

    @FXML
    void Modificar(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Todo
    }
    
}