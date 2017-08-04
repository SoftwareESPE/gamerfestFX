/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import static administracion.EditarOrganizadoresController.setMenuOrga;
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

public class OrganizadoresController implements Initializable {

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
            setMenuOrga(1);
           AnchorPane panel = FXMLLoader.load(getClass().getResource("EditarOrganizadores.fxml"));
           PanelRoot.getChildren().setAll(panel);
       } catch (IOException ex) {
           Logger.getLogger(SuperAdminController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    void Eliminar(ActionEvent event) {

    }

    @FXML
    void Modificar(ActionEvent event) {
        try {
           setMenuOrga(0);
            AnchorPane panel = FXMLLoader.load(getClass().getResource("EditarOrganizadores.fxml"));
           PanelRoot.getChildren().setAll(panel);
       } catch (IOException ex) {
           Logger.getLogger(SuperAdminController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
