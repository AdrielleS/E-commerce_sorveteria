/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import beans.Consumidor;
import dados.RepositorioConsumidores;

/**
 *
 * @author Jamelly
 */
public class Logins {
    RepositorioConsumidores repConsumidor;
    public Logins(){
        this.repConsumidor = RepositorioConsumidores.getInstance();
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
}
