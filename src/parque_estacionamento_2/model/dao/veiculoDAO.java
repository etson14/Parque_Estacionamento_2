/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import parque_estacionamento_2.model.domain.Veiculo;

/**
 *
 * @author owner
 */
public class veiculoDAO {
    
    Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    
    public List<Veiculo> listarVeiculo(){
    
    String sql="SELECT * FROM Veiculo";
    List<Veiculo> listaVeiculo=new ArrayList<Veiculo>();
    
        try {
            
            PreparedStatement stmt=conexao.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                
            Veiculo veiculo=new Veiculo();
            veiculo.setN_matricula(rs.getString("n_matricula"));
            veiculo.setMarca(rs.getString("marca"));
            veiculo.setModelo(rs.getString("modelo"));
            veiculo.setCor(rs.getString("cor"));
            veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
            listaVeiculo.add(veiculo);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(veiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


    return listaVeiculo;
    }
    
    public boolean insert(Veiculo veiculo){
        String sql="INSERT INTO Veiculo(n_matricula,marca,modelo,cor)VALUES(?,?,?,?)";
        
        PreparedStatement stmt;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, veiculo.getN_matricula());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setString(4, veiculo.getCor());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    public void delete(Veiculo veiculo){
        String sql="DELETE FROM Veiculo where idVeiculo=?";
            
        try {
            
            PreparedStatement stmt =conexao.prepareStatement(sql); 
            
            stmt.setInt(1, veiculo.getIdVeiculo());
            stmt.execute();
                    
                    } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void update(Veiculo veiculo){
        String sql="UPDATE Veiculo SET n_matricula=?,marca=?,modelo=?,cor=? WHERE idVeiculo=?";
        
        try {
            PreparedStatement stmt=conexao.prepareStatement(sql);
            
            stmt.setString(1, veiculo.getN_matricula());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setString(4, veiculo.getCor());
            stmt.setInt(5,    veiculo.getIdVeiculo());
            stmt.execute();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
}

