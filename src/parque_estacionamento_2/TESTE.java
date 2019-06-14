/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque_estacionamento_2;

import java.sql.Connection;
import parque_estacionamento_2.model.database.Database;
import parque_estacionamento_2.model.database.DatabaseFactory;

/**
 *
 * @author owner
 */
public class TESTE {
    public static void main(String[] args) {
        Database db=DatabaseFactory.getDatabase();
        Connection conn=db.conectar();
        System.out.println("conectado com sucesso!");
        db.conectar();
        
    }
}
