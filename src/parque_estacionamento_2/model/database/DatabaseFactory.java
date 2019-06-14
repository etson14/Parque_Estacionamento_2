
package parque_estacionamento_2.model.database;

public class DatabaseFactory {
    public static Database getDatabase(){
        return new DataBaseMySQL(); 
    }

   
}
