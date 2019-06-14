package parque_estacionamento_2.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import parque_estacionamento_2.model.dao.UtilizadorDAO;
import parque_estacionamento_2.model.database.Database;
import parque_estacionamento_2.model.database.DatabaseFactory;
import parque_estacionamento_2.model.domain.Utilizador;


public class TelaAdicionarUtilizadoresController implements Initializable {

    
    @FXML
    private TextField campoNome;
    
    @FXML
    private TextField campoApelido;
    
    @FXML
    private TextField campoUtilizador;
    
    @FXML
    private TextField campoSenha;

    @FXML
    private TextField campoTipo;
    
    @FXML
    private TextField campoEstado;

    @FXML
    private ComboBox<String> cbTipo;
    
    @FXML
    private ComboBox<String> cbEstado;
    
    @FXML
    private Button btnGuardar;
    
    @FXML
    private Button  btnCancelar;
    
    @FXML
    private  AnchorPane apTelaAdicionar;
    
    
    private Stage dialogstage;
    private boolean btnConfirmarCliked=false;
    private Utilizador utilizador;
    
    
    public Stage getDialogstage() {
        return dialogstage;
    }

    public void setDialogstage(Stage dialogstage) {
        this.dialogstage = dialogstage;
    }

    public boolean isBtnConfirmarCliked() {
        return btnConfirmarCliked;
    }

    public void setBtnConfirmarCliked(boolean btnConfirmarCliked) {
        this.btnConfirmarCliked = btnConfirmarCliked;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.campoNome.setText(utilizador.getNome());
        this.campoApelido.setText(utilizador.getApelido());
        this.campoUtilizador.setText(utilizador.getUtilizador());
        this.campoSenha.setText(utilizador.getSenha());
        this.cbTipo.setValue(utilizador.getTipo());
        this.cbEstado.setValue(utilizador.getEstado());
    }
    
        
    
        ObservableList<String> observableListTipo=FXCollections.observableArrayList("Seguranca","Adminstrativo");
        ObservableList<String> observableListEstado=FXCollections.observableArrayList("Ativado","Cancelado");
    
        Database database=DatabaseFactory.getDatabase();
        Connection conexao=database.conectar();
        UtilizadorDAO utilizadorDAO;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        utilizadorDAO.setConexao(conexao);
      cbTipo.setItems(observableListTipo);
      cbEstado.setItems(observableListEstado);
        
        
        
        
    } 
    
    
    public void handlebtnGuardar(){
    
        
        utilizador.setNome(campoNome.getText());
        utilizador.setApelido(campoApelido.getText());
        utilizador.setUtilizador(campoUtilizador.getText());
        utilizador.setSenha(campoSenha.getText());
        utilizador.setTipo(cbTipo.getSelectionModel().getSelectedItem());
        utilizador.setEstado(cbEstado.getSelectionModel().getSelectedItem());
        
        btnConfirmarCliked=true;
        dialogstage.close();
        
    }
    
    
    public void handlebtnCancelar(){
        dialogstage.close();
    }
    
}
