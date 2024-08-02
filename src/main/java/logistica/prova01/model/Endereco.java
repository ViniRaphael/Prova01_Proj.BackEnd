package logistica.prova01.model;

import jakarta.persistence.*;

@Entity
public class Endereco {

    @Id
    private String cep;

    private String rua;
    private String numero;
    private String cidade;
    private String estado;

    // Getters e Setters

    public String getEnderecoCompleto() {
        return rua + ", " + numero + ", " + cidade + " - " + estado + ", " + cep;
    }
}
