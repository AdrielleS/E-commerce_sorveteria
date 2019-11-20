package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import telas.TelaCadastroFuncionario;
import telas.TelaFuncionariosAdmin;

/**
 * FXML Controller class
 *
 * @author Jamelly
 */
public class CadastrofuncionarioController extends Sair implements Initializable {
    @FXML private Button btnVoltar;
    @FXML private Button btnSair;
    @FXML private Button btnCadastrar;
    @FXML private CheckBox ckSorveteiro;
    @FXML private CheckBox ckEntregador;
    @FXML private TextField txtNome;
    @FXML private TextField txtId;
    @FXML private TextField txtSenha;
    @FXML private DatePicker dateData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSair.setOnMouseClicked((MouseEvent e)->{
            sair();
            fechar();
        });
        
        btnVoltar.setOnMouseClicked((MouseEvent e)->{
            TelaFuncionariosAdmin fa = new TelaFuncionariosAdmin();
            try {
                fa.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(CadastrofuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fechar();
            
            
        });
    }    
    
    private void fechar(){
        TelaCadastroFuncionario.getStage().close();
    }
    
}
