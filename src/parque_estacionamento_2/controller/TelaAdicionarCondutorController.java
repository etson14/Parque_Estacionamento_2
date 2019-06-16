
package parque_estacionamento_2.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class TelaAdicionarCondutorController implements Initializable {
    
    @FXML
    private AnchorPane apTelaAddCondutor;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoBI;

    @FXML
    private TextField campoNIF;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnGuardar;

    @FXML
    private TextField campoCartao;

    @FXML
    private ComboBox<String> campoTipo;

    @FXML
    private DatePicker campoData;

    @FXML
    private ComboBox<String> campoSexo;

    ObservableList<String> observableListSexo=FXCollections.observableArrayList("M","F");
    ObservableList<String> observableListTipo=FXCollections.observableArrayList("Aluno","Residente","Funcionario");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        campoTipo.setItems(observableListTipo);
        campoSexo.setItems(observableListSexo);
    }    
    
}
