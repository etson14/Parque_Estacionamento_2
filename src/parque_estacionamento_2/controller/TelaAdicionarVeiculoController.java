/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque_estacionamento_2.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import parque_estacionamento_2.model.domain.Utilizador;
import parque_estacionamento_2.model.domain.Veiculo;

/**
 * FXML Controller class
 *
 * @author owner
 */
public class TelaAdicionarVeiculoController implements Initializable {

    @FXML
    private TextField campoMatricula;

    @FXML
    private TextField campoMarca;

    @FXML
    private TextField campoModelo;
    
    @FXML
    private TextField campoCor;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnGuardar;
    
    private Stage dialogstage;
    private boolean btnConfirmarCliked=false;
    private Veiculo veiculo;

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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.campoMatricula.setText(veiculo.getN_matricula());
        this.campoMarca.setText(veiculo.getMarca());
        this.campoModelo.setText(veiculo.getModelo());
        this.campoCor.setText(veiculo.getCor());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    
    public void handlebtnGuardar(){
    
        
        veiculo.setN_matricula(campoMatricula.getText());
        veiculo.setMarca(campoMarca.getText());
        veiculo.setModelo(campoModelo.getText());
        veiculo.setCor(campoCor.getText());
        
        
        btnConfirmarCliked=true;
        dialogstage.close();
        
    }
    
    
    public void handlebtnCancelar(){
        dialogstage.close();
    }
    
}
