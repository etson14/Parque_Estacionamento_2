
package parque_estacionamento_2.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class TelaAdicionarRegistoController implements Initializable {
    
    @FXML
    private TextField campoMatricula;

    @FXML
    private TextField campoData;

    @FXML
    private TextField campoCondutor;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnGuardar;

    @FXML
    private ComboBox<String> campoTipo;

    @FXML
    private TextField campoVeiculo;

    @FXML
    private TextField campoHora;

    
    ObservableList<String> obeservableList=FXCollections.observableArrayList("Entrada","Saida");
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        campoTipo.setItems(obeservableList);
        campoData.setText(getData());
        campoHora.setText(getHora());
        
    }   
    
    public String getData(){
        DateFormat dataFormatada=new SimpleDateFormat("yyyy-MM-dd");
        Date data=new Date();
        return dataFormatada.format(data);
        
    }
    
    public String getHora(){
        DateFormat dataFormatada=new SimpleDateFormat("HH:MM:SS");
        Date data=new Date();
        return dataFormatada.format(data);
        
    }
}