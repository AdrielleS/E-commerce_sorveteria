/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

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
public class TelaEntregador extends Application{
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent rood = FXMLLoader.load(getClass().getResource("/view/entregador.fxml")); // carrega o fxml
        Scene scene = new Scene(rood); // coloca o fxml em uma cena
        stage.setTitle("E-Sorvetes");
        stage.setScene(scene); // coloca a cena em uma janela
        stage.show(); // abre a janela
        setStage(stage); // seta esse novo stage recebido na variavel stage, muito util para fechar uma jaenela enquanto abre outra
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        TelaEntregador.stage = stage;
    } 
}
