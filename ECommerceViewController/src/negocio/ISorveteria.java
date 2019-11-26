/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import beans.Consumidor;
import beans.Funcionario;

/**
 *
 * @author Jamelly
 */
public interface ISorveteria {
  void cadastrarConsumi(Consumidor c);

  void efetuarLogin();

  void cadastrar(Funcionario f);

  void removerFuncionario(String cpf);

  
    
}
