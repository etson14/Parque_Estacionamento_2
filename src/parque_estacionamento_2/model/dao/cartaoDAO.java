
package parque_estacionamento_2.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parque_estacionamento_2.model.domain.Cartao;
import parque_estacionamento_2.model.domain.Veiculo;


public class cartaoDAO {
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public List<Cartao> listarCartao(){
        String sql="SELECT * FROM Cartao";
        List<Cartao> listaCartao=new ArrayList<Cartao>();
        
        try {
            PreparedStatement stmt=conexao.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                
                Cartao cartao=new Cartao();
                cartao.setIdCartao(rs.getInt("idCartao"));
                cartao.setnCartao(rs.getInt("numeroCartao"));
                cartao.setEstado(rs.getString("estado"));
                listaCartao.add(cartao);
                
                
                System.out.println(cartao.getIdCartao()+"/"+cartao.getnCartao()+"/"+cartao.getEstado());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(cartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaCartao;
    }
    
    public boolean insert(Cartao cartao){
        String sql="INSERT INTO Cartao VALUES(?,?)";
        
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cartao.getnCartao());
            stmt.setString(2, cartao.getEstado());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void delete(Cartao cartao){
        String sql="DELETE FROM Cartao where idCartao=?";
            
        try {
            
            PreparedStatement stmt =conexao.prepareStatement(sql); 
            
            stmt.setInt(1, cartao.getIdCartao());
            stmt.execute();
                    
                    } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void update(Cartao cartao){
        String sql="UPDATE Cartao SET estado=? WHERE idCartao=?";
        
        try {
            PreparedStatement stmt=conexao.prepareStatement(sql);
            
            stmt.setString(1, cartao.getEstado());
            stmt.setInt(2, cartao.getIdCartao() );
            stmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
