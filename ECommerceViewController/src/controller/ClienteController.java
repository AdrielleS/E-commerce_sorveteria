/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Calda;
import beans.Consumidor;
import beans.Incremento;
import beans.Pedido;
import beans.SaborSorvete;
import beans.Sorvete;
import beans.Venda;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import negocio.FachadaSorveteria;
import negocio.ISorveteria;
import telas.TelaCliente;

/**
 * FXML Controller class
 *
 * @author Jamelly
 */
public class ClienteController extends Sair implements Initializable {
    @FXML private Button btnSair;
    @FXML private Label lbPessoa;
    @FXML private AnchorPane tela;
    @FXML private ComboBox<Integer> cbBolas;
    @FXML private CheckBox ckCHoco;
    @FXML private CheckBox ckMor;
    @FXML private CheckBox ckBau;
    @FXML private CheckBox ckLim;
    @FXML private CheckBox ckFlocos;
    @FXML private CheckBox ckPacoca;
    @FXML private CheckBox ckGranulado;
    @FXML private CheckBox ckAmedoim;
    @FXML private CheckBox ckCaldaChoco;
    @FXML private CheckBox ckCaldaMor;
    @FXML private CheckBox ckCaldaLeite;
    @FXML private Button btnFazerPedido;
    @FXML private ComboBox<String> cbFormaPagamento;
    @FXML private Button btnCalcular;
    @FXML private Label precoPedido;
    @FXML private Label precoFrete;
    @FXML private Label precoTotal;

    private Consumidor cliente;
    private ArrayList<SaborSorvete> sabores;
    private Incremento incremento;
    private Calda calda;
    private List<Sorvete> sorvetes;
    private Pedido pedido;
    private Venda venda;
    private ISorveteria fachada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        qtdBolas();
        formaPagamento();
        tela.setOnMouseMoved((MouseEvent e)->{
            label();
        });
        
        btnSair.setOnMouseClicked((MouseEvent e)->{
            sair();
            fecha();
        });
        
        btnFazerPedido.setOnMouseClicked((MouseEvent e)->{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    alert.setHeaderText("Sucesso");
            alert.setTitle("Pedido realizado");
	    alert.setContentText("Pedido realizado com sucesso");
	    alert.show();
            
            try {
                fachada = FachadaSorveteria.getInstance();
                fachada.cadastrarPedido(pedido);
                fachada.cadastrarVenda(venda);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        btnCalcular.setOnMouseClicked((MouseEvent e)->{
            ckBoxes();
            sorvetes = new ArrayList<>();
            Sorvete sorvete = new Sorvete(sabores, incremento, calda, cbBolas.getSelectionModel().getSelectedItem());
            sorvetes.add(sorvete);
            pedido = new Pedido(sorvetes,"Pedido em espera",cliente);
            venda = new Venda(pedido,cbFormaPagamento.getSelectionModel().getSelectedItem());
            precos();
        });
    }    
    
    public void setCliente(Consumidor cliente){
        this.cliente = cliente;
    }
    
    public Consumidor getCliente(){
        return this.cliente;
    }
    
    private void label(){
        lbPessoa.setText(cliente.getNome());
    }
    
    private void precos(){
        precoPedido.setText("R$" + pedido.getPreco());
        precoFrete.setText("R$"+venda.getFrete());
        precoTotal.setText("R$"+venda.getValorTotalPedido());
    }
    
    private void qtdBolas(){
        ObservableList<Integer> bolas = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
        cbBolas.setValue(0);
        cbBolas.setItems(bolas);
    }
    
    private void formaPagamento(){
        ObservableList<String> pagamento = FXCollections.observableArrayList("DINHEIRO","DEBITO","CREDITO");
        cbFormaPagamento.setValue("Forma de pagamento");
        cbFormaPagamento.setItems(pagamento);
    }
    
    private void ckBoxes(){
        sabores = new ArrayList<>();
        if(ckCHoco.isSelected()){
            sabores.add(SaborSorvete.CHOCOLATE);
         
        }
        if(ckMor.isSelected()){
            sabores.add(SaborSorvete.MORANGO);
        }
        if(ckBau.isSelected()){
            sabores.add(SaborSorvete.BAUNILHA);
            
        }
        if(ckLim.isSelected()){
            sabores.add(SaborSorvete.LIMAO);
        }
        if(ckFlocos.isSelected()){
            sabores.add(SaborSorvete.FLOCOS);
        }
        
        if(ckPacoca.isSelected()){
            incremento = Incremento.PACOCA;
        }
        
        if(ckGranulado.isSelected()){
            incremento = Incremento.GRANULADO;
        }
        
        if(ckPacoca.isSelected()){
            incremento = Incremento.AMEDOIM;
        }
        
        if (ckCaldaChoco.isSelected()) {
            calda = Calda.CHOCOLATE;
        }
        
        if (ckCaldaMor.isSelected()) {
            calda = Calda.MORANGO;
        }
        
        if (ckCaldaLeite.isSelected()) {
            calda = Calda.LEITE_CONDENSADO;
        }
           
    }
    
    private void fecha(){
        TelaCliente.getStage().close();
    }
    
}
