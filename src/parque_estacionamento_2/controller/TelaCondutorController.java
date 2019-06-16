
package parque_estacionamento_2.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import parque_estacionamento_2.model.dao.condutorDAO;
import parque_estacionamento_2.model.database.Database;
import parque_estacionamento_2.model.database.DatabaseFactory;
import parque_estacionamento_2.model.domain.Condutor;


public class TelaCondutorController implements Initializable {
    
    @FXML
    private AnchorPane apCondutor;

    @FXML
    private TableView<Condutor> tabelaCondutor;

    @FXML
    private TableColumn<Condutor, Integer> colunaID;

    @FXML
    private TableColumn<Condutor, String> colunaNomeCompleto;

    @FXML
    private TableColumn<Condutor, Integer> colunaBI;

    @FXML
    private TableColumn<Condutor, Integer> colunaNIF;

    @FXML
    private TableColumn<Condutor, String> colunaSexo;

    @FXML
    private TableColumn<Condutor, String> colunaData;

    @FXML
    private TableColumn<Condutor, String> colunaTipo;

    @FXML
    private TableColumn<Condutor, Integer> colunaCartao;

    @FXML
    private JFXButton btnAdicionarCondutor;

    @FXML
    private JFXButton btnEditarVeiculo;

    @FXML
    private JFXButton btnEliminarCondutor;

    List<Condutor> listaCondutor;
    ObservableList<Condutor> observableList;
   
    
    Database database=DatabaseFactory.getDatabase();
    Connection conexao=database.conectar();
    condutorDAO condutordao;
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          //condutordao.setConexao(conexao);
            carregarTabelaCondutor();
        
    }



    public void carregarTabelaCondutor() {
        
        colunaID.setCellValueFactory(new PropertyValueFactory("idCondutor"));
        colunaNomeCompleto.setCellValueFactory(new PropertyValueFactory("nomeCompleto"));
        colunaBI.setCellValueFactory(new PropertyValueFactory("bi"));
        colunaNIF.setCellValueFactory(new PropertyValueFactory("nif"));
        colunaSexo.setCellValueFactory(new PropertyValueFactory("sexo"));
        colunaData.setCellValueFactory(new PropertyValueFactory("dataNascimento"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        colunaCartao.setCellValueFactory(new PropertyValueFactory("Cartao_idCartao"));
        
        listaCondutor=condutordao.listarCondutor();
        
        
        observableList=FXCollections.observableArrayList(listaCondutor);
        tabelaCondutor.setItems(observableList);
        
        
    }
    
}
