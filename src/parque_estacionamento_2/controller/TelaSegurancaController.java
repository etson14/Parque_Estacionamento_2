
package parque_estacionamento_2.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import parque_estacionamento_2.model.dao.TelaAdministrativoDAO;
import parque_estacionamento_2.model.database.Database;
import parque_estacionamento_2.model.database.DatabaseFactory;



public class TelaSegurancaController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;

    @FXML
    private JFXButton btnMP;

    @FXML
    private JFXButton btnV;

    @FXML
    private JFXButton btnR;

    @FXML
    private JFXButton btnLR;

    @FXML
    private JFXButton btnSair;

    @FXML
    private AnchorPane apMP;

    @FXML
    private Text lblVeiculos;

    @FXML
    private Text lblCondutor;

    @FXML
    private Text lblRegistro;
    
    private final Database database=DatabaseFactory.getDatabase();
    private Connection conexo=database.conectar();
    TelaAdministrativoDAO tADAO= new TelaAdministrativoDAO();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tADAO.setConexao(conexo);
        mostrarContVeiculo();
        mostrarContCondutor();
        mostrarContRegisto();
        
    }

    public void mostrarContVeiculo(){
        
        String n=tADAO.contVeiculo();
        
        lblVeiculos.setText(n);
        
    }
    
    public void mostrarContCondutor(){
        
        String n=tADAO.contCondutor();
        
        lblCondutor.setText(n);
        
    }
    
     public void mostrarContRegisto(){
        
        String n=tADAO.contCondutor();
        
        lblRegistro.setText(n);
        
    }  
    
     public void carregarTelaMenuPrincipal() throws IOException{
       AnchorPane a =(AnchorPane)FXMLLoader.load(getClass().getResource("/parque_estacionamento_2/view/TelaSeguranca.fxml"));
       apPrincipal.getChildren().setAll(a);
    }
     
     public void carregarTelaVeiculo() throws IOException{
       AnchorPane a =(AnchorPane)FXMLLoader.load(getClass().getResource("/parque_estacionamento_2/view/TelaVeiculo.fxml"));
       apMP.getChildren().setAll(a);
   }
     
     public void carregarTelaRegistro() throws IOException{
       AnchorPane a =(AnchorPane)FXMLLoader.load(getClass().getResource("/parque_estacionamento_2/view/TelaRegistro.fxml"));
       apMP.getChildren().setAll(a);
   } 
     
     public void Sair() throws IOException{
       AnchorPane a =(AnchorPane)FXMLLoader.load(getClass().getResource("/parque_estacionamento_2/view/TelaLogin.fxml"));
       apPrincipal.getChildren().setAll(a);
   }
     
    
    
}
