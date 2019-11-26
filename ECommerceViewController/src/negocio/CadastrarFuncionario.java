/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import beans.Funcionario;
import dados.RepositorioFuncionarios;
import exceptions.FuncionarioException;

/**
 *
 * @author Jamelly
 */
public class CadastrarFuncionario {
    
    private RepositorioFuncionarios RepFuncionario;

        
    public CadastrarFuncionario(RepositorioFuncionarios instancia){
        this.RepFuncionario = instancia;
    }
    
    public void cadastrar(Funcionario funcionario) throws FuncionarioException{
        this.RepFuncionario.cadastrar(funcionario);
    
    }
}
