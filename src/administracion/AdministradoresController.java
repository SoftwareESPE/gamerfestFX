/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import static administracion.EditarAdministradoresController.setMenuAdmin;
import clases.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static servicios.Operacion.tablaAdminis;

public class AdministradoresController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private AnchorPane PanelRoot;
    
     @FXML
    private TableView<Usuario> Table;

    @FXML
    private JFXButton btn_añadir;

    @FXML
    private JFXButton btn_mod;

    @FXML
    private JFXButton btn_eliminar;
    
    ObservableList<Usuario> Lista;
    
    @FXML
    private TableColumn<Usuario, String> nombre;

    @FXML
    private TableColumn<Usuario, String> apellido;

    @FXML
    private TableColumn<Usuario, String> cedula;

    @FXML
    private TableColumn<Usuario, String> contraseña;
   


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
        this.Lista = FXCollections.observableArrayList();
        Lista = tablaAdminis(servicios.Conexion.getCnx(), Lista);
        this.Table.setItems(Lista);
        this.nombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Nombre"));
        this.apellido.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Apellido"));
        this.cedula.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Cedula"));
        this.contraseña.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Contraseña"));
        
    }    
    
}
