
package controller;

import beans.Pedido;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

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
import negocio.FachadaSorveteria;
import negocio.ISorveteria;
import telas.TelaPedidos;

/**
 * FXML Controller class
 *
 * @author Jamelly
 */
public class PedidosController extends Sair implements Initializable {

    @FXML Button btnSair;
    @FXML private ListView<String> lvPedidos;
    @FXML private Button btnRealizar;
    
    ISorveteria fachada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar();
        btnSair.setOnMouseClicked((MouseEvent e)->{
            sair();
            fechar();
        });
        
       btnRealizar.setOnMouseClicked((MouseEvent e)->{
           ArrayList<Pedido> mudarStatus = new ArrayList<>(fachada.listarPedidos());
           int index = lvPedidos.getSelectionModel().getSelectedIndex();
            if (index == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Selecione um pedido");
                alert.setContentText("Selecione um pedido");
                alert.show();
            }
           fachada.mudarStatus(mudarStatus.get(index-1).getConsumidor().getCpf());
           listar();
        });
        
        
    }   
    
    private void fechar(){
        TelaPedidos.getStage().close();
    }
    
    private void listar() {
        ArrayList<String> listaPedidos = new ArrayList<>();
        try {
            fachada = FachadaSorveteria.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(PedidosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaPedidos.add("CPF do cliente   Sabores   Qtd de bolas   Calda    Incrementos    Status do pedido    Endereço");
        for (Pedido p : fachada.listarPedidos()) {
            listaPedidos.add(p.toString());
        }
        
        ObservableList<String> obsFuncionario = FXCollections.observableArrayList(listaPedidos);
        lvPedidos.setItems(obsFuncionario);
    }
    
}
