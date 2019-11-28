
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import telas.TelaLogin;

public abstract class Sair {
    public void sair(){
        TelaLogin l = new TelaLogin();
            
            try {
                l.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
    

}
