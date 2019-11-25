package controller;

import beans.Funcionario;
import dados.RepositorioFuncionarios;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
    @FXML private ListView<Funcionario> lvFuncionarios;
    private List<Funcionario> funcionarios = new ArrayList<>();
    private ObservableList<Funcionario> obsFuncionario;
    private RepositorioFuncionarios repFuncionario = new RepositorioFuncionarios();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //listarFuncionarios();
        
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
    
    private void listarFuncionarios(){
        obsFuncionario = FXCollections.observableArrayList(repFuncionario.listar());
        lvFuncionarios.setItems(obsFuncionario);
    }
 }

