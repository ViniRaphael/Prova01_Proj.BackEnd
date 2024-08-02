package logistica.prova01.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Rastreamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    private String status;

    private String localizacao;

    @ManyToOne
    @JoinColumn(name = "pacote_id")
    private Pacote pacote;

    // Getters e Setters

    public String getResumo() {
        return "Status: " + status + ", Localização: " + localizacao + ", Data e Hora: " + dataHora;
    }

    public void setStatus(String novoStatus) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
    }

    public void setDataHora(java.sql.Date dataHora2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDataHora'");
    }

    public void setLocalizacao(String localizacao2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLocalizacao'");
    }

    public void setPacote(Pacote pacote2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPacote'");
    }
}
