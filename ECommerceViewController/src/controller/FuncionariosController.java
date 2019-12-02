package controller;

import beans.Funcionario;
import dados.RepositorioFuncionarios;
import java.io.IOException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.FachadaSorveteria;
import negocio.ISorveteria;
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
    @FXML private ListView<String> lvFuncionarios;
    private ObservableList<String> obsFuncionario;
    private ISorveteria fachada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listarFuncionarios();
        
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
        
        btnRemover.setOnMouseClicked((MouseEvent e)->{
            int index = lvFuncionarios.getSelectionModel().getSelectedIndex();
            if (index == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Selecione um funcionario");
                alert.setContentText("Selecione um funcionario");
                alert.show();
            }
            List<Funcionario> funcionarios = new ArrayList<>(fachada.listarFuncionarios());
            fachada.removerFuncionario(funcionarios.get(index - 1));
            listarFuncionarios();
        });
    }

    private void fechar(){
        TelaFuncionariosAdmin.getStage().close();
    }   
    
    private void listarFuncionarios(){
        try {
            fachada = FachadaSorveteria.getInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionariosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FuncionariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        obsFuncionario = FXCollections.observableArrayList(fachada.listarFuncionariosString());
        lvFuncionarios.setItems(obsFuncionario);
    }
 }

