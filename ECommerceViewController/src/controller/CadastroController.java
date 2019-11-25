
package controller;

import beans.Zona;
import dados.RepositorioConsumidores;
import exceptions.ConsumidorException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    RepositorioConsumidores repConsumidor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       zonas();
        btnCadastro.setOnMouseClicked((MouseEvent e)->{
            repConsumidor = new RepositorioConsumidores();
           try {
               repConsumidor.cadastrar(txtNome.getText(), txtEmail.getText(), dateDataNascimento.getValue(), txtSenha.getText(), txtCpf.getText(), txtEndereco.getText(), Zona.valueOf(cbZona.getSelectionModel().getSelectedItem()));
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	       alert.setHeaderText("Sucesso");
	       alert.setTitle("Cadastro realizado");
	       alert.setContentText("Cadastro realizado com sucesso");
	       alert.show();
           } catch (ConsumidorException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(ex.getMessage());
                alert.setContentText(ex.getMessage());
                alert.show();
               Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
           }
            
    }); 
        
        btnVoltar.setOnMouseClicked((MouseEvent e)->{
            TelaLogin l = new TelaLogin();
            try {
                l.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fecha();
        });
    }  
    
    private void fecha(){
        TelaCadastro.getStage().close();
    }
    
    private void zonas(){
        ObservableList<String> zonas = FXCollections.observableArrayList("NORTE","SUL","LESTE","OESTE");
        cbZona.setValue("Zonas");
        cbZona.setItems(zonas);
        cbZona.getSelectionModel().getSelectedItem();// select item escolhido no comboBox
    }
    
}
