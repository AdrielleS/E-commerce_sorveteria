
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import telas.TelaPedidos;

/**
 * FXML Controller class
 *
 * @author Jamelly
 */
public class PedidosController extends Sair implements Initializable {

    @FXML Button btnSair;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSair.setOnMouseClicked((MouseEvent)->{
            sair();
            fechar();
        });
    }   
    
    private void fechar(){
        TelaPedidos.getStage().close();
    }
    
}
