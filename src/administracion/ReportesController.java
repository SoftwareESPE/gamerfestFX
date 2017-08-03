/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import static administracion.loginController.getUsu;
import clases.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Marco Macias
 */
public class ReportesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane PanelRoot;

    @FXML
    private JFXTreeTableView<?> Table;

    @FXML
    private JFXButton btn_modificar;

    @FXML
    private JFXButton btn_guardar;

    @FXML
    private JFXButton btn_cancelar;

    @FXML
    private ComboBox cbox_tipo;

    @FXML
    private JFXButton btn_generar;

    @FXML
    void Cancelar(ActionEvent event) {

    }

    @FXML
    void Generar(ActionEvent event) {

    }

    @FXML
    void Guardar(ActionEvent event) {

    }

    @FXML
    void Modificar(ActionEvent event) {

    }

    @FXML
    void Tipo(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Usuario usu = getUsu();
        if(usu.getTipo()==1){
            this.cbox_tipo.getItems().add("Reporte de inscripciones");
            this.cbox_tipo.getItems().add("Reporte de administradores");
            this.cbox_tipo.getItems().add("Reporte de resultados finales");
        }else if(usu.getTipo()==2){
            this.cbox_tipo.getItems().add("Reporte de administradores");
        }else if(usu.getTipo()==3){
            this.cbox_tipo.getItems().add("Reporte de resultados finales");
        }
    }
}
