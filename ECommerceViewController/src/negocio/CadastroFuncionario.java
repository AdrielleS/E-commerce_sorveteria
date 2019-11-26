/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import beans.Funcionario;
import dados.RepositorioFuncionarios;
import exceptions.FuncionarioException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jamelly
 */
public class CadastroFuncionario {
    
    private RepositorioFuncionarios RepFuncionario;

        
    public CadastroFuncionario(RepositorioFuncionarios instancia) throws IOException{
        this.RepFuncionario = instancia;
        this.RepFuncionario.salvarArquivo();
    }
    
    public void cadastrar(Funcionario funcionario) throws FuncionarioException{
        this.RepFuncionario.cadastrar(funcionario);
    
    }
    

}