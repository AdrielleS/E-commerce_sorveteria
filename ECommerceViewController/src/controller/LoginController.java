
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import telas.TelaAdmin;
import telas.TelaCadastro;
import telas.TelaLogin;

public class LoginController implements Initializable {
    
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtSenha;
    @FXML private Button btnEntrar;
    @FXML private Button btnCadastrar;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnEntrar.setOnMouseClicked((MouseEvent e)->{
            logar();
    });
        
        txtSenha.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                logar();
            }
        });
        
        
        btnCadastrar.setOnMouseClicked((MouseEvent e)->{
            TelaCadastro c = new TelaCadastro();
            try {
                c.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fecha();
        });
        
    }    
    private void fecha() {
        TelaLogin.getStage().close();
    }
    
    private void logar(){
        if (txtUsuario.getText().equals("admin") && txtSenha.getText().equals("admin")) {
                TelaAdmin a = new TelaAdmin();
                try {
                    a.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                fecha();
                
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("ERRO");
                alert.setTitle("Erro ao entrar");
                alert.setContentText("Usuário ou senha invalido, tente novamente");
                alert.show();
            }
    }
    
}
