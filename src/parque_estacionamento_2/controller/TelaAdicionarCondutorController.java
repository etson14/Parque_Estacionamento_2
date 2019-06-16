
package parque_estacionamento_2.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;


public class TelaAdicionarCondutorController implements Initializable {

    ObservableList<String> observableListSexo=FXCollections.observableArrayList("M","F");
    ObservableList<String> observableListTipo=FXCollections.observableArrayList("Aluno","Residente","Funcionario");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
