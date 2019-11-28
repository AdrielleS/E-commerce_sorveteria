/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import beans.Consumidor;
import controller.ClienteController;
import controller.LoginController;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jamelly
 */
public class TelaCliente extends Application{
    private static Stage stage;
    private Consumidor cliente;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
	
	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/cliente.fxml"));
		Parent root = loader.load();
		ClienteController controller = loader.getController();
		controller.setCliente(cliente);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaCliente.stage = stage;
    }
    
}
