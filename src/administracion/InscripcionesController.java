/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class InscripcionesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane PanelRoot;

    @FXML
    private TableView<Inscripciones> Table;

    @FXML
    private JFXButton btn_agregar;

    @FXML
    private JFXButton btn_modificar;

    @FXML
    private JFXButton btn_eliminar;
    
    ObservableList<Inscripciones> Lista;
    //Columnas
    @FXML 
    private TableColumn<Inscripciones, String> nombre;
    @FXML 
    private TableColumn<Inscripciones, String> Apellido;
    @FXML 
    private TableColumn<Inscripciones, String> Fecha;
    @FXML 
    private TableColumn<Inscripciones, String> juego;
    @FXML 
    private TableColumn<Inscripciones, String> valor;

    @FXML
    void Agregar(ActionEvent event) {

    }

    @FXML
    void Eliminar(ActionEvent event) {

    }

    @FXML
    void Modificar(ActionEvent event) {

    }
    
    public static void llenarInformacion(Connection conector, ObservableList<Inscripciones> lista){
        try{
            
            Statement statement = conector.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT A.ins_id, A.ins_nombre, A.ins_apellido, A.jug_fechains, A.usuarios_usu_id, A.juegos_jue_id, B.jue_nombre, B.jue_valor FROM inscripciones A INNER JOIN juegos B ON(A.juegos_jue_id = B.jue_id)");
                                                        
            
            while(resultado.next()){
                lista.add(new Inscripciones(resultado.getInt("ins_id"),
                                            resultado.getString("ins_nombre"),
                                            resultado.getString("ins_apellido"),
                                            resultado.getString("jug_fechains"),
                                            resultado.getInt("usuarios_usu_id"),
                                            resultado.getInt("juegos_jue_id"),
                                            resultado.getString("jue_nombre"),
                                            resultado.getString("jue_valor")));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.Lista = FXCollections.observableArrayList();
        InscripcionesController.llenarInformacion(servicios.Conexion.getCnx(), Lista);
        this.Table.setItems(this.Lista);
        this.nombre.setCellValueFactory(new PropertyValueFactory<Inscripciones, String>("nombre"));
        this.Apellido.setCellValueFactory(new PropertyValueFactory<Inscripciones, String>("apellido"));
        this.Fecha.setCellValueFactory(new PropertyValueFactory<Inscripciones, String>("fecha"));
        this.juego.setCellValueFactory(new PropertyValueFactory<Inscripciones, String>("juego"));
        this.valor.setCellValueFactory(new PropertyValueFactory<Inscripciones, String>("valor"));
    }
}
