/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import telas.TelaLogin;

/**
 *
 * @author Jamelly
 */
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
