/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class InscripcionesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane PanelRoot;

    @FXML
    private JFXTreeTableView<?> Table;

    @FXML
    private JFXButton btn_agregar;

    @FXML
    private JFXButton btn_modificar;

    @FXML
    private JFXButton btn_eliminar;

    @FXML
    void Agregar(ActionEvent event) {

    }

    @FXML
    void Eliminar(ActionEvent event) {

    }

    @FXML
    void Modificar(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Todo
    }
}
