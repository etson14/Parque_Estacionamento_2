
package parque_estacionamento_2.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
    private JFXButton btnEditarCondutor;

    @FXML
    private JFXButton btnEliminarCondutor;

    List<Condutor> listaCondutor;
    ObservableList<Condutor> observableList;
   
    
    Database database=DatabaseFactory.getDatabase();
    Connection conexao=database.conectar();

     condutorDAO condutorDAO=new condutorDAO();   
    
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        
       
        
        condutorDAO.setConexao(conexao);
        carregarTabelaCondutor();
     
     
//    for(Condutor c:listaCondutor){
//    System.out.println(c.getIdCartao()+"/"+c.getNome_Completo()+"/"+c.getSexo()+"/"+c.getEmail()+"/"+c.getData()+"/"+c.getTipo()+"/"+c.getBI()+"/"+c.getNIF()+"/"+c.getIdCartao());
//    
//    }
        
    }



    public void carregarTabelaCondutor() {
        
        colunaID.setCellValueFactory(new PropertyValueFactory("idCondutor"));
        colunaNomeCompleto.setCellValueFactory(new PropertyValueFactory("nomeCompleto"));
        colunaBI.setCellValueFactory(new PropertyValueFactory("BI"));
        colunaNIF.setCellValueFactory(new PropertyValueFactory("NIF"));
        colunaSexo.setCellValueFactory(new PropertyValueFactory("Sexo"));
        colunaData.setCellValueFactory(new PropertyValueFactory("Data"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory("Tipo"));
        colunaCartao.setCellValueFactory(new PropertyValueFactory("idCartao"));
        
        listaCondutor=condutorDAO.listarCondutor();
        
        
        observableList=FXCollections.observableArrayList(listaCondutor);
        tabelaCondutor.setItems(observableList);
        
        
    }
    
}
