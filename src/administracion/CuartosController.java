/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import administracion.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.sql.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import servicios.Conexion;
import servicios.ConexionMySQL;

public class CuartosController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private AnchorPane PanelRoot;

    @FXML
    private JFXButton btn_jugador1;

    @FXML
    private JFXButton btn_jugador5;

    @FXML
    private JFXButton btn_jugador2;

    @FXML
    private JFXButton btn_jugador6;

    @FXML
    private JFXButton btn_jugador3;

    @FXML
    private JFXButton btn_jugador7;

    @FXML
    private JFXButton btn_jugador4;

    @FXML
    private JFXButton btn_jugador8;

    @FXML
    private JFXButton btn_semi1;

    @FXML
    private JFXButton btn_semi2;

    @FXML
    private JFXButton btn_semi3;

    @FXML
    private JFXButton btn_semi4;

    @FXML
    private JFXButton btn_final1;

    @FXML
    private JFXButton btn_final2;

    @FXML
    private JFXButton btn_admin8;

    @FXML
    private JFXButton btn_admin81;

    @FXML
    private JFXButton btn_admin82;

    @FXML
    private JFXButton btn_admin83;

    @FXML
    private JFXButton btn_admin84;

    @FXML
    private JFXButton btn_admin85;

    @FXML
    private JFXButton btn_admin86;

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
        //setVisible(inicial());
        Jugadores();
        
    }
    public boolean inicial(){//Para saber si se ha hecho un registro previo
        boolean resultado=false;
        ConexionMySQL mysql=new ConexionMySQL();
	Connection conector=mysql.Conectar();
        int numero=0;
        try {
            Statement comando=conector.createStatement();
            ResultSet registro=comando.executeQuery("SELECT * from enfrentamientos");
            while(registro.next()){
                numero++;
            }
            if(numero!=0){
                resultado=true;
                System.out.println(numero);
            }
        } catch (Exception e) {
        }
        return resultado;
    }
    
    public void Jugadores(){
        int juego=1;
        ConexionMySQL mysql=new ConexionMySQL();
	Connection conector=mysql.Conectar();
        int numero=0;
        try {
            Statement comando=conector.createStatement();
            ResultSet registro=comando.executeQuery("SELECT * from inscripciones");
            //numero=registro.getMetaData().getColumnCount();
            while(registro.next()){
                if(registro.getInt("juegos_jue_id")==juego){
                System.out.println(registro.getString("ins_nombre"));
                numero++;                
                }
            }
            registro.close();
            int[] ids=new int[8];
            String[] jugador=new String[8];
            registro=comando.executeQuery("SELECT * from inscripciones");
            //numero=registro.getMetaData().getColumnCount();
            numero=0;
            while(registro.next()){
                if(registro.getInt("juegos_jue_id")==juego){
                ids[numero]=registro.getInt("ins_id");
                jugador[numero]=registro.getString("ins_nombre")+" "+registro.getString("ins_apellido");
                numero++;                
                }
            }
            for(int i=numero;i<8;i++){
                ids[i]=0;
                jugador[i]="NoPlayer";
            }
            int n=numero;  //numeros aleatorios
       int k=n;  //auxiliar;
        int[] numeros=new int[n];
        int[] resultado=new int[8];
        Random rnd=new Random();
        int res;
        
        
        //se rellena una matriz ordenada del 1 al 31(1..n)
        for(int i=0;i<n;i++){
            numeros[i]=i;
        }
        
        for(int i=0;i<n;i++){
            res=rnd.nextInt(k);            
            resultado[i]=numeros[res];
            numeros[res]=numeros[k-1];
            k--;
        }
        for(int i=numero;i<8;i++){
                resultado[i]=i;
            }
        System.out.println("El resultado de la matriz es:");
        PreparedStatement pst;
        for(int i=0;i<4;i++){
            //pst=conector.prepareStatement("INSERT INTO enfrentamientos(enf_id,enf_resultado,jugadores_jug_id)"
            //        + "VALUES(?,?,?)");
            //pst=conector.prepareStatement("INSERT INTO enfrentamientos(enf_id,enf_resultado,jugadores_jug_id)"
            //        + "VALUES(?,?,?)");
        }
        btn_jugador1.setText(jugador[resultado[0]]);
        btn_jugador2.setText(jugador[resultado[1]]);
        btn_jugador3.setText(jugador[resultado[2]]);
        btn_jugador4.setText(jugador[resultado[3]]);
        btn_jugador5.setText(jugador[resultado[4]]);
        btn_jugador6.setText(jugador[resultado[5]]);
        btn_jugador7.setText(jugador[resultado[6]]);
        btn_jugador8.setText(jugador[resultado[7]]);
        if(ids[4]==0){
            btn_semi1.setText(jugador[resultado[0]]);
        }
        if(ids[5]==0){
            btn_semi2.setText(jugador[resultado[1]]);
        }
        if(ids[6]==0){
            btn_semi3.setText(jugador[resultado[2]]);
        }
        if(ids[7]==0){
            btn_semi4.setText(jugador[resultado[3]]);
        }
        
            
        for(int i=0;i<4;i++){
            
        }
            
        } catch (Exception e) {
        }
    }
    
}
