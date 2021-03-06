/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import test.*;
import administracion.*;
import static administracion.loginController.getUsu;
import clases.Usuario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
/**
 * FXML Controller class
 *
 * 
 */
public class ReportesOrgController implements Initializable {

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
        Document documento = new Document();
        FileOutputStream ficheroPdf;
        String ruta = null;
        try 
        {
            if(this.cbox_tipo.getSelectionModel().getSelectedItem().equals("Reporte de inscripciones")){
                ruta="D:\\Reporte_inscripciones.PDF";
            }else if(this.cbox_tipo.getSelectionModel().getSelectedItem().equals("Reporte de administradores")){
                ruta="D:\\Reporte_administradores.PDF";
            }else if(this.cbox_tipo.getSelectionModel().getSelectedItem().equals("Reporte de resultados finales")){
                ruta="D:\\Reporte_resultado_final.PDF";
            }
            ficheroPdf = new FileOutputStream(ruta);
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        try{
            documento.open();
                //aqui agregamos todo el contenido del PDF...
            documento.close();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
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
