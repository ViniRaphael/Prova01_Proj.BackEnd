package logistica.prova01.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rastreamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataHora;
    private String status;
    private String localizacao;

    public String getResumo() {
        return String.format("Status: %s, Localização: %s, Data e Hora: %s", status, localizacao, dataHora.toString());
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getDataHora() { return dataHora; }
    public void setDataHora(Date dataHora) { this.dataHora = dataHora; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public void setPacote(Pacote pacote) {
        throw new UnsupportedOperationException("Unimplemented method 'setPacote'");
    }
}

