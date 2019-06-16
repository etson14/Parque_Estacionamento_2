
package parque_estacionamento_2.model.domain;

import java.util.Date;


public class Pessoa {
    
    private String Nome_Completo;
    private int BI;
    private int NIF;
    private String Sexo;
    private String Data;
    private String email;

    public String getNome_Completo() {
        return Nome_Completo;
    }

    public void setNome_Completo(String Nome) {
        this.Nome_Completo = Nome;
    }

    public int getBI() {
        return BI;
    }

    public void setBI(int BI) {
        this.BI = BI;
    }

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
}
