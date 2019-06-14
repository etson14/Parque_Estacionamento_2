
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
import parque_estacionamento_2.model.dao.UtilizadorDAO;
import parque_estacionamento_2.model.database.Database;
import parque_estacionamento_2.model.database.DatabaseFactory;
import parque_estacionamento_2.model.domain.Utilizador;



public class TelaAdminSistemaController implements Initializable {
    
    @FXML
    private AnchorPane apAdminSistema;
    
    @FXML
    private TableView<Utilizador> tabelaUtilizador;
    
    @FXML
    private TableColumn<Utilizador, Integer> colunaID;
    
    @FXML
    private TableColumn<Utilizador, String> colunaNome;
    
    @FXML
    private TableColumn<Utilizador, String> colunaApelido;
    
    @FXML
    private TableColumn<Utilizador, String> colunaUtilizador;
    
    @FXML
    private TableColumn<Utilizador, String> colunaSenha;
    
    @FXML
    private TableColumn<Utilizador, String> colunaTipo;
    
    @FXML
    private TableColumn<Utilizador, String> colunaEstado;
    
    @FXML
    private Button btnCriarConta;
    
    @FXML
    private Button btnEditarConta;
    
    @FXML
    private Button btnCancelar; 
    
    private List<Utilizador> listaUtilizador;
    private ObservableList<Utilizador> observableListUtilizador;
    
    private final Database database= DatabaseFactory.getDatabase();
    private final Connection conexao=database.conectar();//
    private final UtilizadorDAO utilizadorDAO=new UtilizadorDAO();
    

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       utilizadorDAO.setConexao(conexao);
       carregarTabelaUtilizador();    }

    public void carregarTabelaUtilizador(){
        
        colunaID.setCellValueFactory(new PropertyValueFactory("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaApelido.setCellValueFactory(new PropertyValueFactory("apelido"));
        colunaUtilizador.setCellValueFactory(new PropertyValueFactory("utilizador"));
        colunaSenha.setCellValueFactory(new PropertyValueFactory("senha"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        colunaEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        
        listaUtilizador=utilizadorDAO.listarUtilizador();
        
        observableListUtilizador=FXCollections.observableArrayList(listaUtilizador);
        tabelaUtilizador.setItems(observableListUtilizador);
        
        
    }
    
    @FXML
    public void eliminarConta(){
        Utilizador utilizador =tabelaUtilizador.getSelectionModel().getSelectedItem();
        
        if(utilizador!=null){
            //int selectedOption=JOptionPane.showConfirmDialog(null,"Desejas realmente eliminar este utilizador?","",JOptionPane.YES_NO_OPTION);
         
            utilizadorDAO.delete(utilizador);
            //JOptionPane.showMessageDialog(null,"Utilizador eliminado com sucesso!");
            carregarTabelaUtilizador();
            
            
           
            
        }else{
           Alert alert= new Alert(Alert.AlertType.ERROR);
           alert.setContentText("Por favor, selecione um utilizador na tabela que desejas eliminar!");
           alert.show();
        }
        
        
    }
    
    @FXML
    public void actualizarConta() throws IOException{
        Utilizador utilizador=tabelaUtilizador.getSelectionModel().getSelectedItem();
        
        if(utilizador!=null){
         boolean btnConfirmarClicked=showCarregarTelaAdicionarUtilizadores(utilizador);
        if(btnConfirmarClicked){
            utilizadorDAO.update(utilizador);
            carregarTabelaUtilizador();
        } 
        
        }else{
           Alert alert= new Alert(Alert.AlertType.ERROR);
           alert.setContentText("Por favor, selecione um utilizador na tabela que desejas editar!");
           alert.show();
        }
        
        
    }
      @FXML
      public void inserirConta() throws IOException{
        Utilizador utilizador=new Utilizador();
        
         boolean btnConfirmarClicked=showCarregarTelaAdicionarUtilizadores(utilizador);
        if(btnConfirmarClicked){
            utilizadorDAO.insert(utilizador);
            carregarTabelaUtilizador();
        }
        
    }
      
      public boolean showCarregarTelaAdicionarUtilizadores(Utilizador util) throws IOException{
          FXMLLoader loader=new FXMLLoader();
          loader.setLocation(TelaAdicionarUtilizadoresController.class.getResource("/parque_estacionamento_2/view/TelaAdicionarUtilizadores.fxml"));
          AnchorPane page=(AnchorPane)loader.load();
          
          Stage dialogstage=new Stage();
          dialogstage.setTitle("Criar Conta");
          Scene scene=new Scene(page);
          dialogstage.setScene(scene);
          
          TelaAdicionarUtilizadoresController controller=loader.getController();
          controller.setDialogstage(dialogstage);
          controller.setUtilizador(util);
          
          dialogstage.showAndWait();
          
   
          return controller.isBtnConfirmarCliked();
      }
    
    
    
}
