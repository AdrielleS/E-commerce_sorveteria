
package controller;

import beans.Consumidor;
import beans.Zona;
import java.io.IOException;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.FachadaSorveteria;
import negocio.ISorveteria;
import telas.TelaCadastro;
import telas.TelaLogin;

public class CadastroController implements Initializable {
   
    @FXML private TextField txtNome;
    @FXML private TextField txtEmail;
    @FXML private DatePicker dateDataNascimento;
    @FXML private TextField txtCpf;
    @FXML private TextField txtEndereco;
    @FXML private PasswordField txtSenha;
    @FXML private Button btnCadastro;
    @FXML private Button btnVoltar;
    @FXML private ComboBox<String> cbZona;
    ISorveteria fachada;
    FachadaSorveteria fa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       zonas();
           
        btnVoltar.setOnMouseClicked((MouseEvent e)->{
            TelaLogin l = new TelaLogin();
            try {
                l.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fecha();
        });
        
        btnCadastro.setOnMouseClicked((MouseEvent e)->{
            
           try {
               fachada = FachadaSorveteria.getInstance();
               Consumidor c = new Consumidor(txtNome.getText(), txtEmail.getText(), dateDataNascimento.getValue(), txtSenha.getText(), txtCpf.getText(), txtEndereco.getText(), Zona.valueOf(cbZona.getSelectionModel().getSelectedItem())); 
               fachada.cadastrarConsumi(c);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
           }
                     
        });
    }  
    
    private void fecha(){
        TelaCadastro.getStage().close();
    }
    
    private void zonas(){
        ObservableList<String> zonas = FXCollections.observableArrayList("NORTE","SUL","LESTE","OESTE");
        cbZona.setValue("Zonas");
        cbZona.setItems(zonas);
                        // select item escolhido no comboBox
    }
    
}
