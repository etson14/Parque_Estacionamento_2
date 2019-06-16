
package parque_estacionamento_2.model.domain;

import java.util.Date;


public class Pessoa {
    
    private String nomeCompleto;
    private int BI;
    private int NIF;
    private String Sexo;
    private Date Data;
    private String email;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
}
