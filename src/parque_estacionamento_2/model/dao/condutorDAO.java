
package parque_estacionamento_2.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parque_estacionamento_2.model.domain.Condutor;


public class condutorDAO {
    
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public List<Condutor> listarCondutor() {
        
        String sql="Select * FROM Condutor";
        List<Condutor> listaCondutor=new ArrayList<Condutor>();
        
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
        
        while(rs.next()){
            
            Condutor condutor=new Condutor();
            condutor.setNome_Completo(rs.getString("nomeCompleto"));
            condutor.setSexo(rs.getString("sexo"));
            condutor.setData(rs.getString("dataNascimento"));
            condutor.setEmail(rs.getString("email"));
            condutor.setTipo(rs.getString("tipo"));
            condutor.setidCondutor(rs.getInt("idCondutor"));
            condutor.setBI(rs.getInt("bi"));
            condutor.setNIF(rs.getInt("nif"));
            condutor.setIdCartao(rs.getInt("Cartao_idCartao"));
            listaCondutor.add(condutor);
        }
        } catch (SQLException ex) {
            Logger.getLogger(condutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCondutor;
    }
}
