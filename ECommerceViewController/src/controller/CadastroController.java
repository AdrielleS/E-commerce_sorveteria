
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import telas.TelaCadastro;
import telas.TelaLogin;

public class CadastroController implements Initializable {
    
    @FXML private Button btnCadastro;
    @FXML private Button btnVoltar;
    @FXML private ComboBox<String> cbZona;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        
        
        btnCadastro.setOnMouseClicked((MouseEvent e)->{
            ObservableList<String> zonas = FXCollections.observableArrayList("Norte","Sul","Leste","Oeste");
            cbZona.setValue("Zonas");
            cbZona.setItems(zonas);
            cbZona.getSelectionModel().getSelectedItem();// select item escolhido no comboBox;
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
