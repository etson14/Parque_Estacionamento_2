
package parque_estacionamento_2.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TelaAdministrativoDAO {
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public String contVeiculo(){
        String n = "";
        String sql="SELECT COUNT(*) FROM Veiculo";
        
        try {
            PreparedStatement stmt=conexao.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            rs.next();
            n=rs.getString(1);
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdministrativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
     public String contCondutor(){
        String n = "";
        String sql="SELECT COUNT(*) FROM Condutor";
        
        try {
            PreparedStatement stmt=conexao.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            rs.next();
            n=rs.getString(1);
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdministrativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
     
       public String contRegistro(){
        String n = "";
        String sql="SELECT COUNT(*) FROM Registro";
        
        try {
            PreparedStatement stmt=conexao.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            rs.next();
            n=rs.getString(1);
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdministrativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return n;
    }
    
}
