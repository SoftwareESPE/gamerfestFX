/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import test.*;
import administracion.*;
import static administracion.InicioController.mainContainer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PrincipalOrganizadoresController implements Initializable, ControledScreen {
        
    @FXML
    private Pane buttonsPanel;

    @FXML
    private JFXButton btn_admin;

    @FXML
    private JFXButton btn_reportes;

    @FXML
    private JFXButton btn_inscripciones;

    @FXML
    private AnchorPane PanelRoot;

    @FXML
    void Organizadores(ActionEvent event) {
        try {
           AnchorPane panel = FXMLLoader.load(getClass().getResource("PerfilOrganizadores.fxml"));
           PanelRoot.getChildren().setAll(panel);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalOrganizadoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Enfrentamientos(ActionEvent event) {
        try {
           AnchorPane panel = FXMLLoader.load(getClass().getResource("Cuartos.fxml"));
           PanelRoot.getChildren().setAll(panel);
        } catch (IOException ex) {
            System.out.println(ex);
            //Logger.getLogger(PrincipalOrganizadoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Reportes(ActionEvent event) {
        try {
           AnchorPane panel = FXMLLoader.load(getClass().getResource("ReportesOrg.fxml"));
           PanelRoot.getChildren().setAll(panel);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalOrganizadoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void Salir(ActionEvent event) {
        try {
                        mainContainer.loadScreen(InicioController.screen4ID, InicioController.screen4File);
                        PrincipalOrganizadoresController.myController.setScreen(InicioController.screen4ID);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
    }
    
    public static ScreenControled myController;
    
    public void setScreenParent(ScreenControled screenParent){
        myController = screenParent;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           AnchorPane panel = FXMLLoader.load(getClass().getResource("PerfilOrganizadores.fxml"));
           PanelRoot.getChildren().setAll(panel);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalOrganizadoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  

    

    
}
