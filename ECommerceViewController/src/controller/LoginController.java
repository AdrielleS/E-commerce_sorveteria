
package controller;

import beans.Consumidor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.FachadaSorveteria;
import negocio.ISorveteria;
import telas.TelaAdmin;
import telas.TelaCadastro;
import telas.TelaCliente;
import telas.TelaLogin;
import telas.TelaPedidos;

public class LoginController implements Initializable {
    
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtSenha;
    @FXML private Button btnEntrar;
    @FXML private Button btnCadastrar;
    ClienteController cc = new ClienteController();
    Consumidor cliente;
    ISorveteria fachada;


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
        try {
            boolean entrou = false;
             if (txtUsuario.getText().equals("admin") && txtSenha.getText().equals("admin")) {
                 entrou = true;
                TelaAdmin a = new TelaAdmin();
                try {
                    a.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                fecha();
            }
            fachada = FachadaSorveteria.getInstance();
            if (entrou == false) {
                
                if (fachada.efetuarLogin(txtUsuario.getText(), txtSenha.getText()) != null) {               
                    TelaCliente tc = new TelaCliente();          
                    cliente = fachada.efetuarLogin(txtUsuario.getText(), txtSenha.getText());
                    entrou = true;
                    mudarTela();
                    fecha();
            }
                
                if (entrou == false) {
                    if (fachada.efetuarLoginFunci(txtUsuario.getText(), txtSenha.getText()) != null) {
                    TelaPedidos tp = new TelaPedidos();
                    try {
                        tp.start(new Stage());
                    } catch (Exception ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    entrou = true;
                    fecha();
                    
                }
                    else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("ERRO");
                alert.setTitle("Erro ao entrar");
                alert.setContentText("Usuário ou senha invalido, tente novamente");
                alert.show();
            }  
              }
           }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Consumidor getCliente(){
        return cliente;
    }
    
    	@FXML public void mudarTela() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/cliente.fxml"));
		Parent root = loader.load();
		ClienteController controller = loader.getController();
		controller.setCliente(cliente);
		
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
} 

    


