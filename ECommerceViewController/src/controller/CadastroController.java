
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import telas.TelaCadastro;
import telas.TelaLogin;

public class CadastroController implements Initializable {
    
    @FXML private Button btnCadastro;
    @FXML private Button btnVoltar;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCadastro.setOnMouseClicked((MouseEvent e)->{
     
    }); 
        
        btnVoltar.setOnMouseClicked((MouseEvent e)->{
            TelaLogin l = new TelaLogin();
            fecha();
            try {
                l.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }  
    
    private void fecha(){
        TelaCadastro.getStage().close();
    }
    
}
