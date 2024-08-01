package logistica.prova01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Endereco {
    
    @Id
    private String cep;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;

    public String getEnderecoCompleto() {
        return String.format("%s, %s - %s, %s, %s", rua, numero, cidade, estado, cep);
    }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
