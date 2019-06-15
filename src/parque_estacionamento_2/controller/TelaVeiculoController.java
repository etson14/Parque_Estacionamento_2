
package parque_estacionamento_2.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import parque_estacionamento_2.model.dao.veiculoDAO;
import parque_estacionamento_2.model.database.Database;
import parque_estacionamento_2.model.database.DatabaseFactory;
import parque_estacionamento_2.model.domain.Utilizador;
import parque_estacionamento_2.model.domain.Veiculo;


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
    
    public void insertVeiculo() throws IOException{
        Veiculo veiculo=new Veiculo();
        
        boolean btnConfirmarClicked=showCarregarTelaAdicionarVeiculo(veiculo);
        if(btnConfirmarClicked){
            veiculoDAO.insert(veiculo);
            carregarTelaVeiculo();
        } 

        
    }
    
    public void editarVeiculo() throws IOException{
        Veiculo veiculo=tabelaVeiculo.getSelectionModel().getSelectedItem();
        
        if(veiculo !=null){
             boolean btnConfirmarClicked=showCarregarTelaAdicionarVeiculo(veiculo);
        if(btnConfirmarClicked){
            veiculoDAO.update(veiculo);
            carregarTelaVeiculo();
        } 

            
            
        }else{
           Alert alert= new Alert(Alert.AlertType.ERROR);
           alert.setContentText("Por favor, selecione um veiculo na tabela que desejas editar!");
           alert.show();
        }
        
        
    }
    
    
    
    public void eliminarVeiculo(){
        Veiculo veiculo=tabelaVeiculo.getSelectionModel().getSelectedItem();
        
        if(veiculo !=null){
            veiculoDAO.delete(veiculo);
            carregarTelaVeiculo();
            
        }else{
           Alert alert= new Alert(Alert.AlertType.ERROR);
           alert.setContentText("Por favor, selecione um veiculo na tabela que desejas eliminar!");
           alert.show();
        }
    }
    
    public boolean showCarregarTelaAdicionarVeiculo(Veiculo veiculo) throws IOException{
          FXMLLoader loader=new FXMLLoader();
          loader.setLocation(TelaAdicionarVeiculoController.class.getResource("/parque_estacionamento_2/view/TelaAdicionarVeiculo.fxml"));
          AnchorPane page=(AnchorPane)loader.load();
          
          Stage dialogstage=new Stage();
          dialogstage.setTitle("Adicionar Veiculo");
          dialogstage.setResizable(false);
          Scene scene=new Scene(page);
          dialogstage.setScene(scene);
          
          TelaAdicionarVeiculoController controller=loader.getController();
          controller.setDialogstage(dialogstage);
          controller.setVeiculo(veiculo);
          
          dialogstage.showAndWait();
          
   
          return controller.isBtnConfirmarCliked();
      }
    
}
