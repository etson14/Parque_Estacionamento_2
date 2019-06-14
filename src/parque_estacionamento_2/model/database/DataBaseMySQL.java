
package parque_estacionamento_2.model.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author owner
 */
public class DataBaseMySQL implements Database {
    
   private Connection conn;

    @Override
    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn=DriverManager.getConnection("jdbc:mysql://192.168.64.2/parque_estacionamento", "root","");
            return this.conn;
        } catch (SQLException |ClassNotFoundException ex) {
            Logger.getLogger(DataBaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            }
    }

    @Override
    public void desconectar(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
