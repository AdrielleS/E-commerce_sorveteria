/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import beans.Consumidor;
import controller.CadastroController;
import dados.RepositorioConsumidores;
import exceptions.ConsumidorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Jamelly
 */
public class CadastrarConsumidor {
    private  RepositorioConsumidores RepConsumidor;

        
    public CadastrarConsumidor(RepositorioConsumidores instancia){
        this.RepConsumidor = instancia;
    }
    
    public void cadastrar(Consumidor consumidor) throws ConsumidorException, IOException{
        this.RepConsumidor.cadastrar(consumidor);
        this.RepConsumidor.salvarArquivo();
    }
}
