
package parque_estacionamento_2.model.domain;

import java.util.ArrayList;
import java.util.List;


public class Condutor extends Pessoa {
    private int idCondutor;
    private String Tipo;
    private int idCartao;
    
    public int getidCondutor(){
        return this.idCondutor;
    }
    
    public void setidCondutor(int idCondutor){
        this.idCondutor=idCondutor;
    }
    
    public String getTipo(){
        return this.Tipo;
    }
    
    public void setTipo(String tipo){
        this.Tipo=Tipo;
    }

    public int getIdCondutor() {
        return idCondutor;
    }

    public void setIdCondutor(int idCondutor) {
        this.idCondutor = idCondutor;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }
    
    
    
    
    
    
}

    



