/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Consumidor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Jamelly
 */
public class ClienteController implements Initializable {
    private String cliente;
    LoginController lc = new LoginController();
    @FXML private Button btnSair;
    @FXML private Label lbPessoa;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    
    
    private void cliente(){
 
    }
    public void setCliente(String cpf){
        this.cliente = cpf;
    }
    
    public String getCliente(Consumidor cliente){
        return this.cliente;
    }
    
}
