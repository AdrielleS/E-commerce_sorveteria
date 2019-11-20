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
import telas.TelaAdmin;
import telas.TelaCadastroFuncionario;
import telas.TelaFuncionariosAdmin;

/**
 * FXML Controller class
 *
 * @author Jamelly
 */
public class FuncionariosController extends Sair implements Initializable {

    @FXML private Button btnVoltar;
    @FXML private Button btnSair;
    @FXML private Button btnAtualizar;
    @FXML private Button btnRemover;
    @FXML private Button btnCadastro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSair.setOnMouseClicked((MouseEvent e)->{
            sair();
            fechar();
        });
        
        btnVoltar.setOnMouseClicked((MouseEvent e)->{
            TelaAdmin ta = new TelaAdmin();
            try {
                ta.start(new Stage());
                        } catch (Exception ex) {
                Logger.getLogger(FuncionariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fechar();
        });
        
        btnCadastro.setOnMouseClicked((MouseEvent e)->{
            TelaCadastroFuncionario cf = new TelaCadastroFuncionario();
            try {
                cf.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(FuncionariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fechar();
            
        });
    }

    private void fechar(){
        TelaFuncionariosAdmin.getStage().close();
    }   
 }

