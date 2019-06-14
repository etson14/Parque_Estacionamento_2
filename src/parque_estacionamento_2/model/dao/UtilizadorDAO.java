
package parque_estacionamento_2.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parque_estacionamento_2.model.domain.Utilizador;


public class UtilizadorDAO {
    
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    
    public List<Utilizador> listarUtilizador(){
       
    String sql="SELECT * FROM utilizador";
    List<Utilizador> listaUtilizador=new ArrayList<Utilizador>();

        try {
            PreparedStatement stmt=conexao.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                
                Utilizador utilizador=new Utilizador();
                
                utilizador.setNome(rs.getString("nome"));
                utilizador.setApelido(rs.getString("apelido"));
                utilizador.setUtilizador(rs.getString("utilizador"));
                utilizador.setSenha(rs.getString("senha"));
                utilizador.setTipo(rs.getString("tipo"));
                utilizador.setEstado(rs.getString("estado"));
                utilizador.setId(rs.getInt("id"));
                listaUtilizador.add(utilizador);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaUtilizador;
    }
    
    public boolean insert(Utilizador util){
        String sql="INSERT INTO utilizador(nome,apelido,utilizador,senha,tipo,estado)VALUES(?,?,?,?,?,?)";
        
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, util.getNome());
            stmt.setString(2, util.getApelido());
            stmt.setString(3, util.getUtilizador());
            stmt.setString(4, util.getSenha());
            stmt.setString(5, util.getTipo());
            stmt.setString(6, util.getEstado());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void delete(Utilizador util){
        String sql="DELETE FROM utilizador where id=?";
            
        try {
            
            PreparedStatement stmt =conexao.prepareStatement(sql); 
            
            stmt.setInt(1, util.getId());
            stmt.execute();
                    
                    } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void update(Utilizador util){
        String sql="UPDATE utilizador SET nome=?,apelido=?,utilizador=?,senha=?,tipo=?,estado=?  WHERE id=?";
        
        try {
            PreparedStatement stmt=conexao.prepareStatement(sql);
            
            stmt.setString(1, util.getNome());
            stmt.setString(2, util.getApelido());
            stmt.setString(3, util.getUtilizador());
            stmt.setString(4, util.getSenha());
            stmt.setString(5, util.getTipo());
            stmt.setString(6, util.getEstado());
            stmt.setInt(7,    util.getId());
            stmt.execute();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    
}
