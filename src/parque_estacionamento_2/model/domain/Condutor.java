
package parque_estacionamento_2.model.domain;


public class Condutor extends Pessoa {
    private int idCondutor;
    private String Tipo;
    
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
    
    
}



