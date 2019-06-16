
package parque_estacionamento_2.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import parque_estacionamento_2.model.dao.cartaoDAO;
import parque_estacionamento_2.model.database.Database;
import parque_estacionamento_2.model.database.DatabaseFactory;
import parque_estacionamento_2.model.domain.Cartao;
import parque_estacionamento_2.model.domain.Veiculo;


public class TelaCartaoController implements Initializable {
    
    @FXML
    private AnchorPane apCartao;

    @FXML
    private JFXButton btnDesativarCartao;

    @FXML
    private TableView<Cartao> tabelaCartao;
    
    @FXML
    private TableColumn<Cartao, String> colunaEstado;
    
    @FXML
    private TableColumn<Cartao, Integer> colunaID;

    @FXML
    private TableColumn<Cartao, Integer> colunaNumero;

    @FXML
    private JFXButton btnAtivarCartao;
    
    List<Cartao> listaCartao;
    ObservableList<Cartao> observableList;
    
    Database database=DatabaseFactory.getDatabase();
    Connection conexao=database.conectar();
    cartaoDAO cartaodao=new cartaoDAO();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       cartaodao.setConexao(conexao);
       carregarTelaCartao();
    } 
    
    public void carregarTelaCartao(){
        
        colunaNumero.setCellValueFactory(new PropertyValueFactory("idCartao"));
        colunaID.setCellValueFactory(new PropertyValueFactory("numeroCartao"));
        colunaEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        
        
       listaCartao=cartaodao.listarCartao();
       
       observableList=FXCollections.observableArrayList(listaCartao);
       tabelaCartao.setItems(observableList);
       
        
    }
    
    public void insertCartao(){
        Cartao cartao=new Cartao();
        
       
    }
    
    public void updateCartaoAtivo(){
        Cartao cartao=tabelaCartao.getSelectionModel().getSelectedItem();
        
        
        if(cartao!=null){
            
            if(cartao.getEstado().equals("activado")){
                cartao.setEstado("desactivado");
                cartaodao.update(cartao);
                carregarTelaCartao();
                
            }else{
                Alert alert= new Alert(Alert.AlertType.ERROR);
                alert.setContentText("O cartao ja se encontra Desactivado!!");
                alert.show();
            }
            
        }else{
            
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, selecione o cartao!");
            alert.show();
            
        }
    }
    
    public void updateCartaoDesactivado(){
        Cartao cartao=tabelaCartao.getSelectionModel().getSelectedItem();
        
        
        if(cartao!=null){
            
            if(cartao.getEstado().equals("desactivado")){
                cartao.setEstado("activado");
                cartaodao.update(cartao);
                carregarTelaCartao();
                
            }else{
                Alert alert= new Alert(Alert.AlertType.ERROR);
                alert.setContentText("O cartao ja se encontra Activado!!");
                alert.show();
            }
            
        }else{
            
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, selecione o cartao!");
            alert.show();
            
        }
    }
    
}
