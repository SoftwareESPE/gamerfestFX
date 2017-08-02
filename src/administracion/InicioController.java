/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author josue
 */
public class InicioController implements Initializable, ControledScreen {
    
    public static ScreenControled myController;
    public static String screen0ID = "main";
    public static String screen0File = "login.fxml";
    public static String screen1ID = "screen1";
    public static String screen1File = "SuperAdmin.fxml";
    
    public void setScreenParent(ScreenControled screenParent){
        myController = screenParent;
    }
    @FXML
    private JFXButton btn_iniciar;
    
    @FXML
    void iniciarSistema(ActionEvent event) {
        ScreenControled mainContainer = new ScreenControled();
        mainContainer.loadScreen(InicioController.screen0ID, InicioController.screen0File);
        mainContainer.loadScreen(InicioController.screen1ID, InicioController.screen1File);
        mainContainer.setScreen(InicioController.screen0ID);
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
