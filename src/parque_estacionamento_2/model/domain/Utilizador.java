
package parque_estacionamento_2.model.domain;

public class Utilizador {
    
    private int Id;
    private String Nome;
    private String Apelido;
    private String Utilizador;
    private String Senha;
    private String Tipo;
    private String Estado;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    } 

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setApelido(String Apelido) {
        this.Apelido = Apelido;
    }

    public String getUtilizador() {
        return Utilizador;
    }

    public void setUtilizador(String Utilizador) {
        this.Utilizador = Utilizador;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
