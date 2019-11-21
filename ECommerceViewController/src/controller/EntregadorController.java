/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import telas.TelaEntregador;

/**
 * FXML Controller class
 *
 * @author Jamelly
 */
public class EntregadorController extends Sair implements Initializable {

    @FXML private Button btnEntrega;

    @FXML private Button btnSair;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSair.setOnMouseClicked((MouseEvent e)->{
            sair();
            fechar();
        });
    }    
    private void fechar(){
        TelaEntregador.getStage().close();
    }
}
