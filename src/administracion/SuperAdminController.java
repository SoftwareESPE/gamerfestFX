/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author Marco Macias
 */
public class SuperAdminController implements Initializable, ControledScreen {
    

    public static ScreenControled myController;
   
    public void setScreenParent(ScreenControled screenParent){
        myController = screenParent;
    }
    /**
     * Initializes the controller class.
     */
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
}
