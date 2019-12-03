/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import telas.TelaEntregador;

/**
 * FXML Controller class
 *
 * @author Jamelly
 */
public class EntregadorController extends Sair implements Initializable {

    @FXML private Button btnEntrega;
    @FXML private Button btnSair;
    @FXML private ListView<String> lvEntregas;
    @FXML private Button btnEntregue;
    ISorveteria fachada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar();
        btnSair.setOnMouseClicked((MouseEvent e)->{
            sair();
            fechar();
        });
        
        btnEntrega.setOnMouseClicked((MouseEvent e)->{
           ArrayList<Pedido> mudarStatus = new ArrayList<>(fachada.listaEntregas());
           int index = lvEntregas.getSelectionModel().getSelectedIndex();
            if (index == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Selecione um pedido");
                alert.setContentText("Selecione um pedido");
                alert.show();
            }
            
           fachada.entregaStatus(mudarStatus.get(index - 1).getConsumidor().getCpf());
           listar();
        });
        
        btnEntregue.setOnMouseClicked((MouseEvent e)->{
           ArrayList<Pedido> mudarStatus = new ArrayList<>(fachada.listaEntregas());
           int index = lvEntregas.getSelectionModel().getSelectedIndex();
            if (index == -1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Selecione um pedido");
                alert.setContentText("Selecione um pedido");
                alert.show();
            }
           fachada.entregueStatus(mudarStatus.get(index - 1).getConsumidor().getCpf());
           listar();
        });
        
        
    }    
    private void fechar(){
        TelaEntregador.getStage().close();
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
        for (Pedido p : fachada.listaEntregas()) {
            listaPedidos.add(p.toString());
        }
        
        ObservableList<String> obsFuncionario = FXCollections.observableArrayList(listaPedidos);
        lvEntregas.setItems(obsFuncionario);
    }
}
