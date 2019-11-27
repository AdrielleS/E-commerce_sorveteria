/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import beans.Consumidor;
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
        Parent rood = FXMLLoader.load(getClass().getResource("/view/cliente.fxml"));
        Scene scene = new Scene(rood);
        stage.setTitle("Bem Vindo");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaCliente.stage = stage;
    }
    
    public void setCliente(Consumidor cliente){
        this.cliente = cliente;
    }
    
    public Consumidor getCliente(){
        return this.cliente;
    }
}
