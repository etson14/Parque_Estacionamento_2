/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque_estacionamento_2.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import parque_estacionamento_2.model.dao.veiculoDAO;
import parque_estacionamento_2.model.database.Database;
import parque_estacionamento_2.model.database.DatabaseFactory;
import parque_estacionamento_2.model.domain.Veiculo;

/**
 * FXML Controller class
 *
 * @author owner
 */
public class TelaVeiculoController implements Initializable {

    @FXML
    private TableView<Veiculo> tabelaVeiculo;
    
    @FXML
    private TableColumn<Veiculo, Integer> colunaID;
    
    @FXML
    private TableColumn<Veiculo, String> colunaMatricula;
    
    @FXML
    private TableColumn<Veiculo, String> colunaMarca;
    
    @FXML
    private TableColumn<Veiculo, String> colunaModelo;
    
    @FXML
    private TableColumn<Veiculo, String> colunaCor;
    
    @FXML
    private Button btnAdicionarVeiculo;
    
    @FXML
    private Button btnEditarVeiculo;
    
    @FXML
    private Button btnEliminarVeiculo;
    
    List<Veiculo> listaVeiculo;
    ObservableList<Veiculo> observableList;
    
    Database database=DatabaseFactory.getDatabase();
    Connection conexao=database.conectar();
    veiculoDAO veiculoDAO=new veiculoDAO();
    
    
    
          
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       veiculoDAO.setConexao(conexao);
       carregarTelaVeiculo();
    }


    public void carregarTelaVeiculo(){
        
        colunaID.setCellValueFactory(new PropertyValueFactory("idVeiculo"));
        colunaMatricula.setCellValueFactory(new PropertyValueFactory("n_matricula"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        colunaModelo.setCellValueFactory(new PropertyValueFactory("modelo"));
        colunaCor.setCellValueFactory(new PropertyValueFactory("cor"));
        
        listaVeiculo=veiculoDAO.listarVeiculo();
        
        observableList=FXCollections.observableArrayList(listaVeiculo);
        tabelaVeiculo.setItems(observableList);
        
    }
    
}
