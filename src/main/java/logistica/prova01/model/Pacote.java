package logistica.prova01.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pacote {

    @Id
    private String id;

    private String destinatario;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private String status;

    @OneToMany(mappedBy = "pacote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rastreamento> rastreamentos = new ArrayList<>();

    // Getters e Setters

    public void atualizarStatus(String novoStatus, Date dataHora, String localizacao) {
        this.status = novoStatus;
        Rastreamento rastreamento = new Rastreamento();
        rastreamento.setStatus(novoStatus);
        rastreamento.setDataHora(dataHora);
        rastreamento.setLocalizacao(localizacao);
        rastreamento.setPacote(this);
        rastreamentos.add(rastreamento);
    }

    public String consultarInformacoes() {
        StringBuilder info = new StringBuilder("ID: " + id + ", Destinatário: " + destinatario + ", Status: " + status);
        for (Rastreamento r : rastreamentos) {
            info.append("\n").append(r.getResumo());
        }
        return info.toString();
    }

    public void setId(String id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
