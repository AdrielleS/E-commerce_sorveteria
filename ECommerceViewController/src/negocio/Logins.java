
package negocio;

import beans.Consumidor;
import beans.Funcionario;
import dados.RepositorioConsumidores;
import dados.RepositorioFuncionarios;

/**
 *
 * @author Jamelly
 */
public class Logins {
    RepositorioConsumidores repConsumidor;
    RepositorioFuncionarios repFuncionario;
    public Logins(){
        this.repConsumidor = RepositorioConsumidores.getInstance();
        this.repFuncionario = RepositorioFuncionarios.getInstance();
    }
    
    public Consumidor login(String usuario, String senha){
        Consumidor cliente = null;
        for (Consumidor c : repConsumidor.listar()) {
            if (c.getEmail().equals(usuario) && c.getSenha().equals(senha)) {
                cliente = c;
            }
        }
        return cliente;
    }
    
    public Funcionario loginFunci(String usuario, String senha){
        Funcionario funcionario = null;
        for (Funcionario f : repFuncionario.listarFuncionarios()) {
            if (f.getNome().equals(usuario) && f.getSenha().equals(senha)) {
                funcionario = f;
            }  
        }
         return funcionario;
    }
}
