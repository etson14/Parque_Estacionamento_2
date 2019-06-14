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

    
    
    
}

