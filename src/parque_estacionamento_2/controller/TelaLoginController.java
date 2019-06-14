
package parque_estacionamento_2.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import parque_estacionamento_2.model.dao.UtilizadorDAO;
import parque_estacionamento_2.model.database.Database;
import parque_estacionamento_2.model.database.DatabaseFactory;
import parque_estacionamento_2.model.domain.Utilizador;


public class TelaLoginController implements Initializable {
    
    @FXML
    private Button btnEntrar;
    @FXML
    private TextField txtFieldUtilizador;
    @FXML
    private TextField txtFieldPP;
    @FXML
    private AnchorPane apLogin;
    @FXML
    private Label lblErro;
    
    
    private Database database=DatabaseFactory.getDatabase();
    private Connection conexao =database.conectar();
    private UtilizadorDAO utilizadorDAO= new UtilizadorDAO();
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        utilizadorDAO.setConexao(conexao);
        
        
        btnEntrar.setOnMouseClicked((MouseEvent e)->{
            try {
                Login();
            } catch (IOException ex) {
                Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            });
        
    }
    
   

    public void Login() throws IOException{
        
        String utilLog=txtFieldUtilizador.getText();
        
        String senha=txtFieldPP.getText();
        
        Utilizador util=selecionarUtilizador(utilLog,senha);
        List<Utilizador> listaUtilizador=utilizadorDAO.listarUtilizador();
        
        if(util!=null){
            
           if(util.getTipo().equals("AdminSistema")){
               
               if(util.getEstado().equals("Ativado")){
                  AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/parque_estacionamento_2/view/TelaAdminSistema.fxml"));
                  apLogin.getChildren().setAll(a);
                   
               }else{
                   lblErro.setText("Conta cancelado!");
               }
               
           }else if(util.getTipo().equals("Seguranca")){
               if(util.getEstado().equals("Ativado")){
                   AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/parque_estacionamento_2/view/TelaSeguranca.fxml"));
                   apLogin.getChildren().setAll(a);
                   
               }else{
                   lblErro.setText("Conta cancelado!");
                   
           }
        
           }else if(util.getTipo().equals("Administrativo")){
               
               if(util.getEstado().equals("Ativado")){
                   AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/parque_estacionamento_2/view/TelaAdministrativo.fxml"));
                   apLogin.getChildren().setAll(a);
                   
               }else{
                   lblErro.setText("Conta cancelado!");
               }
            
           }
        }else{
            lblErro.setText("Este utilizador nao existe");
            
        }

    }
    
    public Utilizador selecionarUtilizador(String string,String string2){
        List<Utilizador> listaUtilizador=utilizadorDAO.listarUtilizador();
        
        for(Utilizador u:listaUtilizador){
            if(u.getUtilizador().equals(string) && u.getSenha().equals(string2))
                return u;
        }
        
        return null;
    }
    
    
}
