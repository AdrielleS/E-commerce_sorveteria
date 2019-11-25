
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
import telas.TelaEntregador;
import telas.TelaFuncionariosAdmin;
import telas.TelaLogin;
import telas.TelaPedidos;

/**
 * FXML Controller class
 *
 * @author Jamelly
 */
public class AdminController extends Sair implements Initializable {

  
    @FXML private Button btnFuncionarios;
    @FXML private Button btnPedidos;
    @FXML private Button btnEntregas;
    @FXML private Button btnSair;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSair.setOnMouseClicked((MouseEvent e)->{
            sair();
            fecha();
        });
        
        btnFuncionarios.setOnMouseClicked((MouseEvent e)->{
           TelaFuncionariosAdmin fa = new TelaFuncionariosAdmin();
            try {
                fa.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fecha();
        });
        
        btnPedidos.setOnMouseClicked((MouseEvent e)->{
            TelaPedidos tp = new TelaPedidos();
            try {
                tp.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fecha();
        });
        
        btnEntregas.setOnMouseClicked((MouseEvent e)->{
            TelaEntregador te = new TelaEntregador();
            try {
                te.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fecha();  
            
        });
    }
    
    
    private void fecha(){
        TelaAdmin.getStage().close();
    }
}
