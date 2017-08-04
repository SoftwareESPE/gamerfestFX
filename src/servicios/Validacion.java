/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.jfoenix.controls.JFXTextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author josue
 */
public class Validacion {
    public static void validarLetras(final JFXTextField texto){
        texto.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try{
                    Pattern permitido = Pattern.compile("[A-Za-zÑÇÁÉÍÓÚÀÈÌÒÙÏÜÂÊÎÔÛñçáéíóúàèìòùïüâêîôû]");
                Matcher mpermitido = permitido.matcher(newValue.substring(oldValue.length()));
                if (!mpermitido.find()) {
                    // caracter no permitido, borrarlo
                    texto.setText(oldValue);
                    return;
                }
                }catch(Exception i){                   
                }              
                
            }
            
        });
    }
    public static void validarNumero(final JFXTextField texto){
        texto.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try{
                    Pattern permitido = Pattern.compile("[0-9]");
                Matcher mpermitido = permitido.matcher(newValue.substring(oldValue.length()));
                if (!mpermitido.find()) {
                    // caracter no permitido, borrarlo
                    texto.setText(oldValue);
                    return;
                }
                }catch(Exception i){                   
                }              
                
            }
            
        });
    }
}
