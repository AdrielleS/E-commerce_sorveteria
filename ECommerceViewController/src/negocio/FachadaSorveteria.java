/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import beans.Consumidor;
import beans.Funcionario;
import dados.RepositorioConsumidores;
import dados.RepositorioFuncionarios;
import exceptions.ConsumidorException;
import exceptions.FuncionarioException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Jamelly
 */
public class FachadaSorveteria implements ISorveteria{
    private final CadastroFuncionario funcionario;
    private final CadastroConsumidor consumidor;
    private static ISorveteria instance;
    
    public FachadaSorveteria() throws ClassNotFoundException, IOException {
        this.funcionario = new CadastroFuncionario(RepositorioFuncionarios.getInstance());
        this.consumidor = new CadastroConsumidor(RepositorioConsumidores.getInstance());
        
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

    @Override
    public void efetuarLogin() {
    }

    @Override
    public void cadastrar(Funcionario f) {
        try {
            funcionario.cadastrar(f);
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
    public void removerFuncionario(String cpf) {
    }


}
