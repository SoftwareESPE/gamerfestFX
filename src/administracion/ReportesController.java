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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * FXML Controller class
 *
 * 
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
    
    ObservableList<Inscripciones> Lista;
    ObservableList<clases.Usuario> Usuarios;

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
                ruta="/reportes/Reporte_inscripciones.PDF";
            }else if(this.cbox_tipo.getSelectionModel().getSelectedItem().equals("Reporte de administradores")){
                ruta="/reportes/Reporte_administradores.PDF";
            }else if(this.cbox_tipo.getSelectionModel().getSelectedItem().equals("Reporte de resultados finales")){
                ruta="/reportes/Reporte_resultado_final.PDF";
            }
            ficheroPdf = new FileOutputStream(System.getProperty("user.dir")+ruta);
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        try{
            documento.open();
            Font fuente= new Font();
            fuente.setSize(35);
                if(this.cbox_tipo.getSelectionModel().getSelectedItem().equals("Reporte de inscripciones")){
                    Paragraph Titulo = new Paragraph("Reporte de inscripciones", fuente);
                    Titulo.setAlignment(1);
                    documento.add(Titulo);
                    documento.add(new Paragraph(" "));
                    documento.add(new Paragraph(" "));
                    PdfPTable tabla = new PdfPTable(5);
                    tabla.addCell("NOMBRE");
                    tabla.addCell("APELLIDO");
                    tabla.addCell("FECHA DE INSCRIPCION");
                    tabla.addCell("JUEGO");
                    tabla.addCell("VALOR");
                    int total=0;
                    for(int x=0; x<this.Lista.size();x++){
                        tabla.addCell(this.Lista.get(x).getNombre());
                        tabla.addCell(this.Lista.get(x).getApellido());
                        tabla.addCell(this.Lista.get(x).getFecha());
                        tabla.addCell(this.Lista.get(x).getJuego());
                        tabla.addCell(this.Lista.get(x).getValor());
                        total+=Float.parseFloat(this.Lista.get(x).getValor());
                    }
                    documento.add(new Paragraph("Cantidad de inscripciones: "+String.valueOf(this.Lista.size())));
                    documento.add(new Paragraph("Dinero Recaudado: "+total));
                    documento.add(new Paragraph(" "));
                    documento.add(tabla);
                }else if(this.cbox_tipo.getSelectionModel().getSelectedItem().equals("Reporte de administradores")){
                    Paragraph Titulo = new Paragraph("Reporte de administradores", fuente);
                    Titulo.setAlignment(1);
                    documento.add(Titulo);
                    for(int i=0;i<this.Usuarios.size();i++){
                        documento.add(new Paragraph(" "));
                        documento.add(new Paragraph(" "));
                        PdfPTable tabla = new PdfPTable(5);
                        documento.add(new Paragraph(this.Usuarios.get(i).getNombre()+" "+this.Usuarios.get(i).getApellido()));
                        tabla.addCell("NOMBRE");
                        tabla.addCell("APELLIDO");
                        tabla.addCell("FECHA DE INSCRIPCION");
                        tabla.addCell("JUEGO");
                        tabla.addCell("VALOR");
                        int total=0,inscritos=0;
                        for(int x=0; x<this.Lista.size();x++){
                            if(this.Usuarios.get(i).getId()==this.Lista.get(x).getUsu_id()){
                                tabla.addCell(this.Lista.get(x).getNombre());
                                tabla.addCell(this.Lista.get(x).getApellido());
                                tabla.addCell(this.Lista.get(x).getFecha());
                                tabla.addCell(this.Lista.get(x).getJuego());
                                tabla.addCell(this.Lista.get(x).getValor());
                                total+=Float.parseFloat(this.Lista.get(x).getValor());
                                inscritos++;
                            }
                        }
                        documento.add(new Paragraph("Cantidad de inscripciones: "+inscritos));
                        documento.add(new Paragraph("Dinero Recaudado: "+total));
                        documento.add(new Paragraph(" "));
                        documento.add(tabla);
                    }
                }else if(this.cbox_tipo.getSelectionModel().getSelectedItem().equals("Reporte de resultados finales")){
                    documento.addTitle("Reporte de resultados finales");
                }
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
        this.Usuarios = FXCollections.observableArrayList();
        this.Usuarios = servicios.Operacion.tablaAdminis(servicios.Conexion.getCnx(), Usuarios);
        this.Lista = FXCollections.observableArrayList();
        InscripcionesController.llenarInformacion(servicios.Conexion.getCnx(), Lista);
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
