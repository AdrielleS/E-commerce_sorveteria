/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import beans.Consumidor;
import beans.Entrega;
import beans.Funcionario;
import beans.Pedido;
import beans.Venda;
import exceptions.ConsumidorException;
import exceptions.FuncionarioException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import exceptions.VendaException;
import java.util.List;

import javafx.scene.control.Alert;

/**
 *
 * @author Jamelly
 */
public class FachadaSorveteria implements ISorveteria{
    private final CadastroFuncionario funcionario;
    private final CadastroConsumidor consumidor;
    private final CadastroPedido pedido;
    private final CadastroVendas venda;
    private final CadastroEntregas entrega;
    private final Logins logins;
    
    private static ISorveteria instance;
    
    private FachadaSorveteria() throws ClassNotFoundException, IOException {
        this.funcionario = new CadastroFuncionario();
        this.consumidor = new CadastroConsumidor();
        this.pedido = new CadastroPedido();
        this.venda = new CadastroVendas();
        this.entrega = new CadastroEntregas();
        this.logins = new Logins();
    }
    
    public static ISorveteria getInstance() throws ClassNotFoundException, IOException {
    if (instance == null) {
      instance = new FachadaSorveteria();
    }
    return instance;
  }

    @Override
    public void cadastrarConsumi(Consumidor c) {
        try {
            this.consumidor.cadastrar(c);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    alert.setHeaderText("Sucesso");
            alert.setTitle("Cadastro realizado");
	    alert.setContentText("Cadastro realizado com sucesso");
	    alert.show();
        } catch (ConsumidorException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Cliente já cadastrado");
            alert.setContentText(ex.getMessage());
            alert.show();
            Logger.getLogger(FachadaSorveteria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FachadaSorveteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Consumidor buscarConsumi(String cpf){
        Consumidor cliente = null;
        try {
            cliente = consumidor.buscar(cpf);
        } catch (ConsumidorException ex) {
            Logger.getLogger(FachadaSorveteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Override
    public Consumidor efetuarLogin(String usuario, String senha) {
        Consumidor cliente = null;
        if (this.logins.login(usuario, senha) != null) {
            cliente = this.logins.login(usuario, senha);
        }
        return cliente;
    }
    
    @Override
    public Funcionario efetuarLoginFunci(String usuario, String senha) {
        Funcionario funcionarios = null;
        if (this.logins.loginFunci(usuario, senha) != null) {
            funcionarios = this.logins.loginFunci(usuario, senha);
        }
        return funcionarios;
    }

    @Override
    public void cadastrar(Funcionario f) {
        try {
            this.funcionario.cadastrar(f);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    alert.setHeaderText("Sucesso");
            alert.setTitle("Cadastro realizado");
	    alert.setContentText("Cadastro realizado com sucesso");
	    alert.show();
        } catch (FuncionarioException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Funcionario já cadastrado");
            alert.setContentText(ex.getMessage());
            alert.show();
            Logger.getLogger(FachadaSorveteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removerFuncionario(Funcionario funci) {
        try {
            funcionario.remover(funci);
        } catch (FuncionarioException ex) {
            Logger.getLogger(FachadaSorveteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cadastrarPedido(Pedido pedido) {
        this.pedido.cadastrar(pedido);
        }

    @Override
    public void cadastrarVenda(Venda venda) {
        try {
            this.venda.cadastrar(venda);
        } catch (VendaException ex) {
            Logger.getLogger(FachadaSorveteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    @Override
    public List<Pedido> listarPedidos() {
       return pedido.listarTodosPedidos();
    }

    @Override
    public List<String> listarFuncionariosString() {
        return funcionario.listar();
        }
    
    @Override
    public void mudarStatus(String cpf){
        pedido.mudarStatus(cpf);
    }

    @Override
    public void entregaStatus(String cpf) {
        pedido.entregaStatus(cpf);
    }

    @Override
    public void entregueStatus(String cpf) {
        pedido.entregueStatus(cpf);
        }

    @Override
    public List<Funcionario> listarFuncionarios() {
        return funcionario.listarFuncionario();
        }

    @Override
    public void removerPedido(Pedido pedidos) {
        pedido.remover(pedidos);
    }
    

    @Override
    public void cadastrarEntrega(Pedido pedidos) {
        pedido.cadastrarEntrega(pedidos);
    }

    @Override
    public List<Pedido> listaEntregas() {
        return pedido.listaEntregador();
    }

    

    
    
    
    


}
