/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import static administracion.EditarAdministradoresController.setMenuAdmin;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class AdministradoresController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private AnchorPane PanelRoot;
    @FXML
    private JFXTreeTableView<?> Table;

    @FXML
    private JFXButton btn_añadir;

    @FXML
    private JFXButton btn_mod;

    @FXML
    private JFXButton btn_eliminar;

    @FXML
    void Añadir(ActionEvent event) {
        try {
           setMenuAdmin(1);
           AnchorPane panel = FXMLLoader.load(getClass().getResource("EditarAdministradores.fxml"));
           PanelRoot.getChildren().setAll(panel);
       } catch (IOException ex) {
           Logger.getLogger(SuperAdminController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
      @FXML
    void Modificar(ActionEvent event) {
        try {
           setMenuAdmin(0);
           AnchorPane panel = FXMLLoader.load(getClass().getResource("EditarAdministradores.fxml"));
           PanelRoot.getChildren().setAll(panel);
       } catch (IOException ex) {
           Logger.getLogger(SuperAdminController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    void Eliminar(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
