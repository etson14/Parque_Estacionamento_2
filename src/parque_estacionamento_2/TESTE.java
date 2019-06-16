/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque_estacionamento_2;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import parque_estacionamento_2.model.dao.condutorDAO;
import parque_estacionamento_2.model.database.Database;
import parque_estacionamento_2.model.database.DatabaseFactory;
import parque_estacionamento_2.model.domain.Condutor;

/**
 *
 * @author owner
 */
public class TESTE {
    public static void main(String[] args) {
        List<Condutor> listaCondutor=new ArrayList<Condutor>();
        Database database=DatabaseFactory.getDatabase();
        Connection conexao=database.conectar();
        condutorDAO condutorDAO=new condutorDAO();
        
        //condutorDAO.setConexao(conexao);
        listaCondutor=condutorDAO.listarCondutor();
        
        for(Condutor c:listaCondutor){
            System.out.println(c.getIdCartao()+"/"+c.getNomeCompleto()+"/"+c.getSexo()+"/"+c.getEmail()+"/"+c.getData()+"/"+c.getTipo()+"/"+c.getBI()+"/"+c.getNIF()+"/"+c.getIdCartao());
//    
        }
        
        
        
        
    }
}
